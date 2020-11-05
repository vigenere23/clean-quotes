package quotes.infrastructure.quotes

import quotes.entities.quotes.Quote
import quotes.entities.quotes.QuotesQueryBuilder
import quotes.entities.quotes.QuotesRepository

class QuotesInMemoryRepository: QuotesRepository {
    private var quotes: MutableList<Quote>

    constructor() {
        quotes = ArrayList()
    }

    constructor(quotes: List<Quote>) {
        this.quotes = quotes.toMutableList()
    }

    override fun queryBuilder(): QuotesQueryBuilder {
        return QuotesInMemoryQueryBuilder(quotes)
    }
}
