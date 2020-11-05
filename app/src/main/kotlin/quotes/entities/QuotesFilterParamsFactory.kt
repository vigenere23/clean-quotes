package quotes.entities

class QuotesFilterParamsFactory {
    fun create(
            minDailyChange: Double?,
            currency: String?,
            minMarketCap: Double?
    ): QuotesFilterParams {
        return QuotesFilterParams(
            minDailyChange = if (minDailyChange != null) Amount(minDailyChange) else null,
            currency = if (currency != null) Currency(currency) else null,
            minMarketCap = if (minMarketCap != null) Amount(minMarketCap) else null
        )
    }
}
