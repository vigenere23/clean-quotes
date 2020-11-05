package quotes.entities.quotes

import quotes.entities.Amount
import quotes.entities.Currency
import java.time.LocalDate

class Quote(
        private val symbol: String,
        private val name: String,
        private val marketCap: Amount,
        private val price: Amount,
        private val dailyChange: Amount,
        private val dailyChangePercent: Double,
        private val currency: Currency,
        private val date: LocalDate
) {
    fun getSymbol(): String {
        return symbol
    }

    fun getName(): String {
        return name
    }

    fun getMarketCap(): Amount {
        return marketCap
    }

    fun getPrice(): Amount {
        return price
    }

    fun getDailyChange(): Amount {
        return dailyChange
    }

    fun getDailyChangePercent(): Double {
        return dailyChangePercent
    }

    fun getCurrency(): Currency {
        return currency
    }

    fun getDate(): LocalDate {
        return date
    }
}
