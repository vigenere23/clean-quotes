package quotes.infrastructure.quotes

import quotes.entities.quotes.QuotesQueryBuilder
import quotes.entities.quotes.QuotesRepository

class QuotesSQLRepository(
        // private val dbConnection: DBConnection
): QuotesRepository {
    override fun queryBuilder(): QuotesQueryBuilder {
        return QuotesSQLQueryBuilder("SELECT * FROM quotes" /*, dbConnection*/)
    }
}
