package quotes.quote.entities

import quotes.shared.entities.Amount
import quotes.shared.entities.Currency

interface QuotesQueryBuilder {
    fun withMinDailyChange(amount: Amount?): QuotesQueryBuilder
    fun withCurrency(currency: Currency?): QuotesQueryBuilder
    fun withMinMarketCap(marketCap: Amount?): QuotesQueryBuilder
    fun results(): List<Quote>
}
