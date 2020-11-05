package quotes.infrastructure.quotes

import quotes.entities.Amount
import quotes.entities.Currency
import quotes.entities.quotes.Quote
import quotes.entities.quotes.QuotesQueryBuilder
import quotes.infrastructure.filters.SQLFilterBuilder

// TODO + SQL string or something
// TODO would have dependencies on SQL connector
class QuotesSQLQueryBuilder(
        private val selection: String
        // private val dbConnection: DBConnection
): QuotesQueryBuilder {
    private val conditionsBuilder = SQLFilterBuilder()

    override fun withMinDailyChange(amount: Amount?): QuotesQueryBuilder {
        if (amount != null) {
            conditionsBuilder.addFilter("quote.dailyChange >= ${amount.getValue()}")
        }
        return this
    }

    override fun withCurrency(currency: Currency?): QuotesQueryBuilder {
        if (currency != null) {
            conditionsBuilder.addFilter("quotes.currency = ${currency.getValue()}")
        }
        return this
    }

    override fun withMinMarketCap(marketCap: Amount?): QuotesQueryBuilder {
        if (marketCap != null) {
            conditionsBuilder.addFilter("quotes.marketCap >= ${marketCap.getValue()}")
        }
        return this
    }

    override fun results(): List<Quote> {
        val query = "$selection ${conditionsBuilder.buildQuery()}"
        // TODO execute query with DB connection
        TODO("Not yet implemented")
    }
}
