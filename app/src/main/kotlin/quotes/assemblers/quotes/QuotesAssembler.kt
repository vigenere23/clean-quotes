package quotes.assemblers.quotes

import quotes.entities.Amount
import quotes.entities.Currency
import quotes.entities.quotes.Quote
import quotes.use_cases.quotes.QuoteDto
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

    fun toEntities(quoteDtos: List<QuoteDto>): List<Quote> {
        return quoteDtos.stream().map { toEntity(it) }.collect(Collectors.toList())
    }

    fun toEntity(quoteDto: QuoteDto): Quote {
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
