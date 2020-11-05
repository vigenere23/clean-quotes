package quotes.entities

interface QuotesRepository {
    fun findAll(quotesFilter: QuotesFilter): List<Quote>
}
