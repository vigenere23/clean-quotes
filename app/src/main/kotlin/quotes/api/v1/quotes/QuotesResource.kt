package quotes.api.v1.quotes

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import quotes.entities.quotes.QuotesFilterParamsFactory
import quotes.use_cases.quotes.GetQuotesUseCase
import java.util.stream.Collectors

fun Routing.quotes(getQuotesUseCase: GetQuotesUseCase, quotesFilterParamsFactory: QuotesFilterParamsFactory) {
    route("/quotes") {
        get {
            val queryParams: Parameters = call.request.queryParameters
            val minDailyChange = extractDouble(queryParams["minDailyChange"])
            val currency = queryParams["currency"]
            val minMarketCap = extractDouble(queryParams["minMarketCap"])
            val filterParams = quotesFilterParamsFactory.create(minDailyChange, currency, minMarketCap)

            val quotes = getQuotesUseCase.execute(filterParams)
            val response = quotes.stream().map { QuoteResponseItem(
                    symbol = it.symbol,
                    name = it.name,
                    price = it.price,
                    date = it.date
            ) }.collect(Collectors.toList())
            call.respond(response)
        }
    }
}

private fun extractDouble(string: String?): Double? {
    if (string == null) return null
    return try {
        string.toDouble()
    } catch (exception: Exception) {
        null
    }
}
