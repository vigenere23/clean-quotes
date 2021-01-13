package quotes.quote.application.assemblers

import quotes.quote.application.dtos.QuoteDto
import quotes.quote.entities.Quote
import quotes.shared.entities.Amount
import quotes.shared.entities.Currency
import java.time.LocalDate
import java.util.stream.Collectors

class QuotesAssembler {
    fun toDtos(quotes: List<Quote>): List<QuoteDto> {
        return quotes.stream().map { toDto(it) }.collect(Collectors.toList())
    }

    fun toDto(quote: Quote): QuoteDto {
        return QuoteDto(
                symbol = quote.getSymbol(),
                name = quote.getName(),
                marketCap = quote.getMarketCap().getValue(),
                price = quote.getPrice().getValue(),
                dailyChange = quote.getDailyChange().getValue(),
                dailyChangePercent = quote.getDailyChangePercent(),
                currency = quote.getCurrency().getValue(),
                date = quote.getDate().toString()
        )
    }

    fun fromDtos(quoteDtos: List<QuoteDto>): List<Quote> {
        return quoteDtos.stream().map { fromDto(it) }.collect(Collectors.toList())
    }

    fun fromDto(quoteDto: QuoteDto): Quote {
        return Quote(
                symbol = quoteDto.symbol,
                name = quoteDto.name,
                marketCap = Amount(quoteDto.marketCap),
                price = Amount(quoteDto.price),
                dailyChange = Amount(quoteDto.dailyChange),
                dailyChangePercent = quoteDto.dailyChangePercent,
                currency = Currency(quoteDto.currency),
                date = LocalDate.parse(quoteDto.date)
        )
    }
}
