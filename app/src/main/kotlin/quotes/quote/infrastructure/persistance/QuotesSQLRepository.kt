package quotes.quote.infrastructure.persistance

import quotes.quote.entities.Quote
import quotes.quote.entities.QuotesQueryBuilder
import quotes.quote.entities.QuotesRepository
import quotes.quote.infrastructure.query_builder.QuotesSQLQueryBuilder

class QuotesSQLRepository(
        // private val dbConnection: DBConnection
): QuotesRepository {
    override fun save(quote: Quote) {
        // TODO transform to DB dto and save
    }

    override fun queryBuilder(): QuotesQueryBuilder {
        return QuotesSQLQueryBuilder("SELECT * FROM quotes" /*, dbConnection*/)
    }
}
