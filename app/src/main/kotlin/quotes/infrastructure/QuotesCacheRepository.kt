package quotes.infrastructure

import quotes.entities.Quote
import quotes.entities.QuotesFilter
import quotes.entities.QuotesRepository

class QuotesCacheRepository: QuotesRepository {
    private var quotes: MutableList<Quote>

    constructor() {
        quotes = ArrayList()
    }

    constructor(quotes: List<Quote>) {
        this.quotes = quotes.toMutableList()
    }

    override fun findAll(quotesFilter: QuotesFilter): List<Quote> {
        return quotesFilter
                .setData(quotes)
                .getResults()
    }
}
