package quotes.modules

import io.ktor.application.*
import io.ktor.routing.*
import quotes.api.v1.quotes
import quotes.assemblers.QuotesAssembler
import quotes.entities.quotes.QuotesFilterParamsFactory
import quotes.entities.quotes.QuotesRepository
import quotes.infrastructure.quotes.QuotesCSVReader
import quotes.infrastructure.quotes.QuotesInMemoryRepository
import quotes.use_cases.quotes.GetQuotesUseCase

fun Application.quotesModule() {
    val quotesRepository = initRepository()
    val quotesFilterParamsFactory = QuotesFilterParamsFactory()
    val quotesAssembler = QuotesAssembler()
    val getQuotesUseCase = GetQuotesUseCase(quotesRepository, quotesAssembler)

    routing {
        quotes(getQuotesUseCase, quotesFilterParamsFactory)
    }
}

private fun initRepository(): QuotesRepository {
    val quotesCSVReader = QuotesCSVReader("quotes.csv")
    return QuotesInMemoryRepository(quotesCSVReader.getAll())
}
