package quotes.shared.infrastructure.filters

import java.util.stream.Collectors

class SQLFilterBuilder {
    private val filters: MutableList<String> = ArrayList()

    fun addFilter(filter: String) {
        filters.add(filter)
    }

    fun buildQuery(): String {
        return filters.stream().map { "WHERE $it" }.collect(Collectors.toList()).joinToString(" AND ")
    }
}
