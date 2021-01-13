package quotes.quote.infrastructure.persistance

import quotes.quote.entities.Quote
import quotes.quote.entities.QuotesQueryBuilder
import quotes.quote.entities.QuotesRepository
import quotes.quote.infrastructure.query_builder.QuotesInMemoryQueryBuilder

class QuotesInMemoryRepository: QuotesRepository {
    private val quotes: MutableSet<Quote> = HashSet()

    override fun save(quote: Quote) {
        quotes.add(quote)
    }

    override fun queryBuilder(): QuotesQueryBuilder {
        return QuotesInMemoryQueryBuilder(quotes.toList())
    }
}
