package quotes.use_cases

import quotes.assemblers.QuotesAssembler
import quotes.entities.QuotesFilterFactory
import quotes.entities.QuotesFilterParams
import quotes.entities.QuotesRepository

class GetQuotesUseCase(
        private val quotesFilterFactory: QuotesFilterFactory,
        private val quotesRepository: QuotesRepository,
        private val quotesAssembler: QuotesAssembler
) {
    fun execute(quotesFilterParams: QuotesFilterParams): List<QuoteDto> {
        val quotesFilter = quotesFilterFactory.create()
                .withMinDailyChange(quotesFilterParams.minDailyChange)
                .withCurrency(quotesFilterParams.currency)
                .withMinMarketCap(quotesFilterParams.minMarketCap)

        val filteredQuotes = quotesRepository.findAll(quotesFilter)
        return quotesAssembler.toDtos(filteredQuotes)
    }
}
