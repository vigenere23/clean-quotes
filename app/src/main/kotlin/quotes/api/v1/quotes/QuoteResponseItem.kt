package quotes.api.v1.quotes

data class QuoteResponseItem(
        val symbol: String,
        val name: String,
        val price: Double,
        val date: String
)
