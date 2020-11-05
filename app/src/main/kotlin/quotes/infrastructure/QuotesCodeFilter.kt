package quotes.infrastructure

import quotes.entities.Amount
import quotes.entities.Currency
import quotes.entities.Quote
import quotes.entities.QuotesFilter
import shared.FilterContainer

class QuotesCodeFilter : QuotesFilter {
    private var originalItems: List<Quote> = ArrayList()
    private val filterContainer: FilterContainer<Quote> = FilterContainer()

    override fun setData(quotes: List<Quote>): QuotesFilter {
        originalItems = quotes
        return this
    }

    override fun withMinDailyChange(amount: Amount?): QuotesFilter {
        if (amount != null) {
            filterContainer.addFilter { quote ->
                quote.getDailyChange() >= amount
            }
        }
        return this
    }

    override fun withCurrency(currency: Currency?): QuotesFilter {
        if (currency != null) {
            filterContainer.addFilter { quote ->
                quote.getCurrency() == currency
            }
        }
        return this
    }

    override fun withMinMarketCap(marketCap: Amount?): QuotesFilter {
        if (marketCap != null) {
            filterContainer.addFilter { quote ->
                quote.getMarketCap() >= marketCap
            }
        }
        return this
    }

    override fun getResults(): List<Quote> {
        return filterContainer
                .setItems(originalItems)
                .getResults()
    }
}
