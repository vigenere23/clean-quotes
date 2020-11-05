package quotes.infrastructure

import quotes.entities.QuotesFilter
import quotes.entities.QuotesFilterFactory

class QuotesCodeFilterFactory: QuotesFilterFactory {
    override fun create(): QuotesFilter {
        return QuotesCodeFilter()
    }
}
