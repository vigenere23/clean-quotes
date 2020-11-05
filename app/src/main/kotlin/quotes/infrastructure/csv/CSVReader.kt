package quotes.infrastructure.csv

import com.github.doyaaaaaken.kotlincsv.dsl.csvReader
import quotes.entities.Amount
import quotes.entities.Currency
import java.io.File
import java.net.URL
import java.time.LocalDate

abstract class CSVReader<T>(
        private val file: String
) {
    private val resource: URL? = javaClass.classLoader.getResource(file)

    protected fun extractString(row: Map<String, String>, key: String): String {
        return row[key] ?: throw CouldNotFindKeyException(file, key)
    }

    protected fun extractDouble(row: Map<String, String>, key: String): Double {
        val value = row[key] ?: throw CouldNotFindKeyException(file, key)
        return value.toDouble()
    }

    protected fun extractAmount(row: Map<String, String>, key: String): Amount {
        val value = row[key] ?: throw CouldNotFindKeyException(file, key)
        return Amount(value)
    }

    protected fun extractCurrency(row: Map<String, String>, key: String): Currency {
        val value = row[key] ?: throw CouldNotFindKeyException(file, key)
        return Currency(value)
    }

    protected fun extractDate(row: Map<String, String>, key: String): LocalDate {
        val value = row[key] ?: throw CouldNotFindKeyException(file, key)
        return LocalDate.parse(value.trim())
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
