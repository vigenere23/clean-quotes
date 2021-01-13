package quotes.quote.api

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import quotes.quote.api.assemblers.QuoteDtoAssembler
import quotes.quote.api.assemblers.QuotesFilterParamsAssembler
import quotes.quote.application.FindingQuotesUseCase

fun Routing.quotes(findingQuotesUseCase: FindingQuotesUseCase, quotesFilterParamsAssembler: QuotesFilterParamsAssembler, quoteDtoAssembler: QuoteDtoAssembler) {
    route("/quotes") {
        get {
            val filterParams = quotesFilterParamsAssembler.fromParams(call.request.queryParameters)
            val quotes = findingQuotesUseCase.execute(filterParams)
            val response = quoteDtoAssembler.toResponse(quotes)
            call.respond(response)
        }
    }
}
