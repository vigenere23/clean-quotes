package quotes.use_cases.quotes

data class QuoteDto(
        val symbol: String,
        val name: String,
        val price: Double,
        val date: String
)
