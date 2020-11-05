package shared

import java.util.stream.Collectors
import java.util.stream.Stream

class FilterContainer<T> {
    private var items: List<T> = ArrayList()
    private val filters: MutableList<(T) -> Boolean> = ArrayList()

    fun setItems(items: List<T>): FilterContainer<T> {
        this.items = items
        return this
    }

    fun addFilter(filter: (T) -> Boolean) {
        filters.add(filter)
    }

    fun getResults(): List<T> {
        var filteredItems: Stream<T> = items.stream()

        filters.forEach { filter ->
            filteredItems = filteredItems.filter { item -> filter(item) }
        }

        return filteredItems.collect(Collectors.toList())
    }
}
