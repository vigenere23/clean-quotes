package quotes.infrastructure.quotes

import quotes.infrastructure.csv.CSVReader
import quotes.use_cases.quotes.QuoteDto
import java.util.stream.Collectors

class QuotesCSVReader(file: String): CSVReader<List<QuoteDto>>(file) {
    override fun getAll(): List<QuoteDto> {
        val rows: List<Map<String, String>> = readAllWithHeader()
        return rows.stream().map { row ->
            QuoteDto(
                    symbol = extractString(row, "SYMBOL"),
                    name = extractString(row, "NAME"),
                    marketCap = extractDouble(row, "MARKETCAP"),
                    price = extractDouble(row, "PRICE"),
                    dailyChange = extractDouble(row, "DAILYCHANGE"),
                    dailyChangePercent = extractDouble(row, "DAILY_CHANGE_PERCENT"),
                    currency = extractString(row, "CURRENCY"),
                    date = extractString(row, "DATE")
            )
        }.collect(Collectors.toList())
    }
}
