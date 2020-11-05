package quotes.infrastructure

import com.github.doyaaaaaken.kotlincsv.dsl.csvReader
import quotes.entities.Amount
import quotes.entities.Currency
import quotes.entities.Quote
import java.io.File
import java.net.URL
import java.time.LocalDate
import java.util.stream.Collectors

class QuotesCSVReader(
        private val file: String
) {
    private val resource: URL? = javaClass.classLoader.getResource(file)

    fun readAll(): List<Quote> {
        if (resource == null) {
            throw Exception("could not load resource for $javaClass")
        }
        val file = File(resource.toURI())
        val rows: List<Map<String, String>> = csvReader().readAllWithHeader(file)
        val quotes = rows.stream().map { row ->
            val marketCap = if (row["MARKETCAP"] != null) Amount((row["MARKETCAP"] ?: error("")).toDouble()) else null

            Quote(
                    symbol = extractString(row, "SYMBOL"),
                    name = extractString(row, "NAME"),
                    marketCap = extractAmount(row, "MARKETCAP"),
                    price = extractAmount(row, "PRICE"),
                    dailyChange = extractAmount(row, "DAILYCHANGE"),
                    dailyChangePercent = extractDouble(row, "DAILY_CHANGE_PERCENT"),
                    currency = extractCurrency(row, "CURRENCY"),
                    date = extractDate(row, "DATE")
            )
        }.collect(Collectors.toList())

        return quotes
    }

    private fun extractString(row: Map<String, String>, key: String): String {
        return row[key] ?: throw CouldNotFindKeyException(file, key)
    }

    private fun extractDouble(row: Map<String, String>, key: String): Double {
        val value = row[key] ?: throw CouldNotFindKeyException(file, key)
        return value.toDouble()
    }

    private fun extractAmount(row: Map<String, String>, key: String): Amount {
        val value = row[key] ?: throw CouldNotFindKeyException(file, key)
        return Amount(value)
    }

    private fun extractCurrency(row: Map<String, String>, key: String): Currency {
        val value = row[key] ?: throw CouldNotFindKeyException(file, key)
        return Currency(value)
    }

    private fun extractDate(row: Map<String, String>, key: String): LocalDate {
        val value = row[key] ?: throw CouldNotFindKeyException(file, key)
        return LocalDate.parse(value.trim())
    }
}
