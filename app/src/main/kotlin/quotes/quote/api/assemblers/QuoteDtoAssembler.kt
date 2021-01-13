package quotes.quote.api.assemblers

import quotes.quote.api.dtos.QuoteResponseItem
import quotes.quote.api.dtos.QuotesResponse
import quotes.quote.application.dtos.QuoteDto
import java.util.stream.Collectors

class QuoteDtoAssembler {

    fun toResponse(quoteDtos: List<QuoteDto>): QuotesResponse {
        val quotes = quoteDtos.stream().map { QuoteResponseItem(
                symbol = it.symbol,
                name = it.name,
                price = it.price,
                date = it.date
        ) }.collect(Collectors.toList())

        return QuotesResponse(
                quotes = quotes
        )
    }
}
