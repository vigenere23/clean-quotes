package quotes.quote.application.dtos

data class QuoteDto(
        val symbol: String,
        val name: String,
        val marketCap: Double,
        val price: Double,
        val dailyChange: Double,
        val dailyChangePercent: Double,
        val currency: String,
        val date: String
)
