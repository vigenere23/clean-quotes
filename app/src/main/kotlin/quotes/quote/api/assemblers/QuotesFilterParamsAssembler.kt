package quotes.quote.api.assemblers

import io.ktor.http.*
import quotes.quote.application.dtos.QuotesFilterParams
import quotes.shared.entities.Amount
import quotes.shared.entities.Currency

class QuotesFilterParamsAssembler {

    fun fromParams(
            params: Parameters
    ): QuotesFilterParams {
        val quotesFilterParams = QuotesFilterParams()
        val minDailyChange = params["minDailyChange"]
        val currency = params["currency"]
        val minMarketCap = params["minMarketCap"]

        if (minDailyChange != null) {
            quotesFilterParams.minDailyChange = Amount(minDailyChange.toDouble())
        }

        if (currency != null) {
            quotesFilterParams.currency = Currency(currency)
        }

        if (minMarketCap != null) {
            quotesFilterParams.minMarketCap = Amount(minMarketCap.toDouble())
        }

        return quotesFilterParams
    }
}
