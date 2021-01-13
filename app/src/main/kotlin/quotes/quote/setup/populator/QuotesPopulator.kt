package quotes.quote.setup.populator

import quotes.quote.entities.QuotesRepository

interface QuotesPopulator {
    fun populateData(quotesRepository: QuotesRepository)
}
