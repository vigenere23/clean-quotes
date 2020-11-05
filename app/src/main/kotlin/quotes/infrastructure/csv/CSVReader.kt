package quotes.infrastructure.csv

import com.github.doyaaaaaken.kotlincsv.dsl.csvReader
import java.io.File
import java.net.URL

abstract class CSVReader<T>(
        private val file: String
) {
    private val resource: URL? = javaClass.classLoader.getResource(file)

    protected fun extractString(row: Map<String, String>, key: String): String {
        return row[key]?.trim() ?: throw CouldNotFindKeyException(file, key)
    }

    protected fun extractDouble(row: Map<String, String>, key: String): Double {
        val value = row[key]?.trim() ?: throw CouldNotFindKeyException(file, key)
        return value.toDouble()
    }

    protected fun readAllWithHeader(): List<Map<String, String>> {
        return csvReader().readAllWithHeader(getFile());
    }

    protected fun readAll(): List<List<String>> {
        return csvReader().readAll(getFile());
    }

    private fun getFile(): File {
        if (resource == null) {
            throw Exception("could not load resource for $javaClass")
        }
        return File(resource.toURI())
    }

    abstract fun getAll(): T
}
