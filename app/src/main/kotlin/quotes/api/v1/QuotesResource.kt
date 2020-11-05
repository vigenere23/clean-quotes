package quotes.api.v1

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import quotes.entities.quotes.QuotesFilterParamsFactory
import quotes.use_cases.quotes.GetQuotesUseCase

fun Routing.quotes(getQuotesUseCase: GetQuotesUseCase, quotesFilterParamsFactory: QuotesFilterParamsFactory) {
    route("/quotes") {
        get {
            val queryParams: Parameters = call.request.queryParameters
            val minDailyChange = extractDouble(queryParams["minDailyChange"])
            val currency = queryParams["currency"]
            val minMarketCap = extractDouble(queryParams["minMarketCap"])
            val filterParams = quotesFilterParamsFactory.create(minDailyChange, currency, minMarketCap)
            call.respond(getQuotesUseCase.execute(filterParams))
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
