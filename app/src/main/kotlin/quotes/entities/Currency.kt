package quotes.entities

class Currency(private val value: String) {
    fun getValue(): String {
        return value
    }

    override fun equals(other: Any?): Boolean {
        if (other == null || other !is Currency) {
            return false
        }

        return other.value == value
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }
}
