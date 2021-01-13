package quotes.quote.api.dtos

data class QuoteResponseItem(
        val symbol: String,
        val name: String,
        val price: Double,
        val date: String
)
