package quotes.quote.application

import quotes.quote.application.assemblers.QuotesAssembler
import quotes.quote.application.dtos.QuoteDto
import quotes.quote.application.dtos.QuotesFilterParams
import quotes.quote.entities.QuotesRepository

class FindingQuotesUseCase(
        private val quotesRepository: QuotesRepository,
        private val quotesAssembler: QuotesAssembler
) {
    fun execute(quotesFilterParams: QuotesFilterParams): List<QuoteDto> {
        val query = quotesRepository.find()
                .withMinDailyChange(quotesFilterParams.minDailyChange)
                .withCurrency(quotesFilterParams.currency)
                .withMinMarketCap(quotesFilterParams.minMarketCap)

        val filteredQuotes = query.getAll()
        return quotesAssembler.toDtos(filteredQuotes)
    }
}
