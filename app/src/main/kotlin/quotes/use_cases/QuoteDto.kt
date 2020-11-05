package quotes.use_cases

data class QuoteDto(
        val symbol: String,
        val name: String,
        val price: Double,
        val date: String
)
