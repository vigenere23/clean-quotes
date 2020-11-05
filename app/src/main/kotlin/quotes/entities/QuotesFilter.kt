package quotes.entities

interface QuotesFilter {
    fun setData(quotes: List<Quote>): QuotesFilter
    fun withMinDailyChange(amount: Amount?): QuotesFilter
    fun withCurrency(currency: Currency?): QuotesFilter
    fun withMinMarketCap(marketCap: Amount?): QuotesFilter
    fun getResults(): List<Quote>
}
