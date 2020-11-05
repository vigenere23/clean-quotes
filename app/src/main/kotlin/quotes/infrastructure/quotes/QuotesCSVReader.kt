package quotes.infrastructure.quotes

import quotes.entities.quotes.Quote
import quotes.infrastructure.csv.CSVReader
import java.util.stream.Collectors

class QuotesCSVReader(file: String): CSVReader<List<Quote>>(file) {
    override fun getAll(): List<Quote> {
        val rows: List<Map<String, String>> = readAllWithHeader()
        return rows.stream().map { row ->
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
    }
}
