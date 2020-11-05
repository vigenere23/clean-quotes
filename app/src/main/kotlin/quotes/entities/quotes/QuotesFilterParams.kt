package quotes.entities.quotes

import quotes.entities.Amount
import quotes.entities.Currency

data class QuotesFilterParams(
        val minDailyChange: Amount?,
        val currency: Currency?,
        val minMarketCap: Amount?
)
