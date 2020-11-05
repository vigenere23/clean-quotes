package quotes.entities.quotes

import quotes.entities.Amount
import quotes.entities.Currency

interface QuotesQueryBuilder {
    fun withMinDailyChange(amount: Amount?): QuotesQueryBuilder
    fun withCurrency(currency: Currency?): QuotesQueryBuilder
    fun withMinMarketCap(marketCap: Amount?): QuotesQueryBuilder
    fun results(): List<Quote>
}
