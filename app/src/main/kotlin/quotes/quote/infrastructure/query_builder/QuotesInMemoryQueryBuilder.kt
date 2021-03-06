package quotes.quote.infrastructure.query_builder

import quotes.quote.entities.Quote
import quotes.quote.entities.QuotesQueryBuilder
import quotes.shared.entities.Amount
import quotes.shared.entities.Currency
import quotes.shared.infrastructure.filters.InMemoryFilterBuilder

class QuotesInMemoryQueryBuilder(
        private val originalItems: List<Quote>
) : QuotesQueryBuilder {
    private val inMemoryFilterBuilder: InMemoryFilterBuilder<Quote> = InMemoryFilterBuilder()

    override fun withMinDailyChange(amount: Amount?): QuotesQueryBuilder {
        if (amount != null) {
            inMemoryFilterBuilder.addFilter { quote ->
                quote.getDailyChange() >= amount
            }
        }
        return this
    }

    override fun withCurrency(currency: Currency?): QuotesQueryBuilder {
        if (currency != null) {
            inMemoryFilterBuilder.addFilter { quote ->
                quote.getCurrency() == currency
            }
        }
        return this
    }

    override fun withMinMarketCap(marketCap: Amount?): QuotesQueryBuilder {
        if (marketCap != null) {
            inMemoryFilterBuilder.addFilter { quote ->
                quote.getMarketCap() >= marketCap
            }
        }
        return this
    }

    override fun getAll(): List<Quote> {
        return inMemoryFilterBuilder
                .setItems(originalItems)
                .getResults()
    }
}
