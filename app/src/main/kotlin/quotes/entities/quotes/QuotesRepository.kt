package quotes.entities.quotes

interface QuotesRepository {
    fun queryBuilder(): QuotesQueryBuilder
}
