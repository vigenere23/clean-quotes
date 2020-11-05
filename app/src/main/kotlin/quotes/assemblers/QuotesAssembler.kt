package quotes.assemblers

import quotes.entities.quotes.Quote
import quotes.use_cases.quotes.QuoteDto
import java.util.stream.Collectors

class QuotesAssembler {
    fun toDtos(quotes: List<Quote>): List<QuoteDto> {
        return quotes.stream().map { toDto(it) }.collect(Collectors.toList())
    }

    fun toDto(quote: Quote): QuoteDto {
        return QuoteDto(
                symbol = quote.getSymbol(),
                name = quote.getName(),
                price = quote.getPrice().getValue(),
                date = quote.getDate().toString()
        )
    }
}
