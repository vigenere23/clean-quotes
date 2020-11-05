package quotes.entities

data class QuotesFilterParams(
        val minDailyChange: Amount?,
        val currency: Currency?,
        val minMarketCap: Amount?
)
