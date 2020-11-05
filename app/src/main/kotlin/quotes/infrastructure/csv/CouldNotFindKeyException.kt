package quotes.infrastructure.csv

class CouldNotFindKeyException: Exception {
    constructor(file: String, key: String): super("Could not find key $key in $file CSV")
    constructor(key: String): super("Could not find key $key in CSV file")
}
