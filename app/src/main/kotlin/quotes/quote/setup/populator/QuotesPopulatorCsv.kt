package quotes.quote.setup.populator

import quotes.quote.application.assemblers.QuotesAssembler
import quotes.quote.entities.QuotesRepository
import quotes.quote.infrastructure.csv.QuotesCSVReader

class QuotesPopulatorCsv(
        private val quotesCSVReader: QuotesCSVReader,
        private val quotesAssembler: QuotesAssembler
): QuotesPopulator {

    override fun populateData(quotesRepository: QuotesRepository) {
        quotesCSVReader.getAll().forEach {quoteDto ->
            val quote = quotesAssembler.fromDto(quoteDto)
            quotesRepository.save(quote)
        }
    }
}
