package quotes.quote.application.dtos

import quotes.shared.entities.Amount
import quotes.shared.entities.Currency

data class QuotesFilterParams(
        var minDailyChange: Amount? = null,
        var currency: Currency? = null,
        var minMarketCap: Amount? = null
)
