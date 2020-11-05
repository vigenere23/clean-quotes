package quotes.infrastructure

import quotes.entities.QuotesFilter
import quotes.entities.QuotesFilterFactory

class QuotesSQLFilterFactory: QuotesFilterFactory {
    override fun create(): QuotesFilter {
        // TODO add dependencies
        return QuotesSQLFilter()
    }
}
