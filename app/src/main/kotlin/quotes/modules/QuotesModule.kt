package quotes.modules

import io.ktor.application.*
import io.ktor.routing.*
import quotes.api.v1.quotes.quotes
import quotes.assemblers.quotes.QuotesAssembler
import quotes.entities.quotes.QuotesFilterParamsFactory
import quotes.entities.quotes.QuotesRepository
import quotes.infrastructure.quotes.QuotesCSVReader
import quotes.infrastructure.quotes.QuotesInMemoryRepository
import quotes.use_cases.quotes.GetQuotesUseCase

fun Application.quotesModule() {
    val quotesFilterParamsFactory = QuotesFilterParamsFactory()
    val quotesAssembler = QuotesAssembler()
    val quotesCSVReader = QuotesCSVReader("quotes.csv")
    val quotesRepository = initRepository(quotesCSVReader, quotesAssembler)
    val getQuotesUseCase = GetQuotesUseCase(quotesRepository, quotesAssembler)

    routing {
        quotes(getQuotesUseCase, quotesFilterParamsFactory)
    }
}

private fun initRepository(quotesCSVReader: QuotesCSVReader, quotesAssembler: QuotesAssembler): QuotesRepository {
    return QuotesInMemoryRepository(quotesAssembler.toEntities(quotesCSVReader.getAll()))
}
