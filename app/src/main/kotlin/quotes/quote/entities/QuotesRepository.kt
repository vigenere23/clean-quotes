package quotes.quote.entities

interface QuotesRepository {
    fun save(quote: Quote)
    fun find(): QuotesQueryBuilder
}
