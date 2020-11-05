package quotes.entities

import java.math.BigDecimal

class Amount: Comparable<Amount> {
    private var value: BigDecimal = BigDecimal.ZERO

    constructor(value: Double) {
        this.value = BigDecimal.valueOf(value)
    }

    constructor(value: String) {
        this.value = BigDecimal(value)
    }

    fun getValue(): Double {
        return value.toDouble()
    }

    override fun equals(other: Any?): Boolean {
        if (other == null || other !is Amount) {
            return false
        }

        return other.value == value
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }

    override fun compareTo(other: Amount): Int {
        return value.compareTo(other.value)
    }
}
