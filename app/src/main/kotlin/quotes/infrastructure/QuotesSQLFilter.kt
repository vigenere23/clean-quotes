package quotes.infrastructure

import quotes.entities.Amount
import quotes.entities.Currency
import quotes.entities.Quote
import quotes.entities.QuotesFilter

// TODO + SQL string or something
// TODO would have dependencies on SQL connector
class QuotesSQLFilter: QuotesFilter {
    override fun setData(quotes: List<Quote>): QuotesFilter {
        TODO("Not yet implemented")
    }

    override fun withMinDailyChange(amount: Amount?): QuotesFilter {
        TODO("Not yet implemented")
    }

    override fun withCurrency(currency: Currency?): QuotesFilter {
        TODO("Not yet implemented")
    }

    override fun withMinMarketCap(marketCap: Amount?): QuotesFilter {
        TODO("Not yet implemented")
    }

    override fun getResults(): List<Quote> {
        TODO("Not yet implemented")
    }
}
