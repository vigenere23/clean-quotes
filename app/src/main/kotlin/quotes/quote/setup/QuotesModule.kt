package quotes.quote.setup

import io.ktor.application.*
import io.ktor.routing.*
import quotes.quote.api.assemblers.QuoteDtoAssembler
import quotes.quote.api.assemblers.QuotesFilterParamsAssembler
import quotes.quote.api.quotes
import quotes.quote.application.FindingQuotesUseCase
import quotes.quote.application.assemblers.QuotesAssembler
import quotes.quote.infrastructure.csv.QuotesCSVReader
import quotes.quote.infrastructure.persistance.QuotesInMemoryRepository
import quotes.quote.setup.populator.QuotesPopulatorCsv

fun Application.quotesModule() {
    // TODO separate into dev, prod and test sub-classes to init dependencies
    // TODO find a way to init routing in sub-classes

    val quotesAssembler = QuotesAssembler()
    val quotesFilterParamsAssembler = QuotesFilterParamsAssembler()
    val quoteDtoAssembler = QuoteDtoAssembler()

    val quotesRepository = QuotesInMemoryRepository()
    val quotesCSVReader = QuotesCSVReader("quotes.csv")
    val quotesPopulator = QuotesPopulatorCsv(quotesCSVReader, quotesAssembler)
    quotesPopulator.populateData(quotesRepository)

    val findingQuotesUseCase = FindingQuotesUseCase(quotesRepository, quotesAssembler)

    routing {
        quotes(findingQuotesUseCase, quotesFilterParamsAssembler, quoteDtoAssembler)
    }
}
