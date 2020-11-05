package quotes.modules

import io.ktor.application.*
import io.ktor.routing.*
import quotes.api.v1.quotes
import quotes.assemblers.QuotesAssembler
import quotes.entities.QuotesFilterParamsFactory
import quotes.entities.QuotesRepository
import quotes.infrastructure.QuotesCSVReader
import quotes.infrastructure.QuotesCacheRepository
import quotes.infrastructure.QuotesCodeFilterFactory
import quotes.use_cases.GetQuotesUseCase

fun Application.quotesModule() {
    val quotesFilterFactory = QuotesCodeFilterFactory()
    val quotesRepository = initRepository()
    val quotesFilterParamsFactory = QuotesFilterParamsFactory()
    val quotesAssembler = QuotesAssembler()
    val getQuotesUseCase = GetQuotesUseCase(quotesFilterFactory, quotesRepository, quotesAssembler)

    routing {
        quotes(getQuotesUseCase, quotesFilterParamsFactory)
    }
}

private fun initRepository(): QuotesRepository {
    val quotesCSVReader = QuotesCSVReader("quotes.csv")
    return QuotesCacheRepository(quotesCSVReader.readAll())
}
