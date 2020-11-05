package quotes.use_cases.quotes

import quotes.assemblers.QuotesAssembler
import quotes.entities.quotes.QuotesFilterParams
import quotes.entities.quotes.QuotesRepository

class GetQuotesUseCase(
        private val quotesRepository: QuotesRepository,
        private val quotesAssembler: QuotesAssembler
) {
    fun execute(quotesFilterParams: QuotesFilterParams): List<QuoteDto> {
        val query = quotesRepository.queryBuilder()
                .withMinDailyChange(quotesFilterParams.minDailyChange)
                .withCurrency(quotesFilterParams.currency)
                .withMinMarketCap(quotesFilterParams.minMarketCap)

        val filteredQuotes = query.results()
        return quotesAssembler.toDtos(filteredQuotes)
    }
}
