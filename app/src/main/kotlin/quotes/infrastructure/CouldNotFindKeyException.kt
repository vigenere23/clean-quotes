package quotes.infrastructure

class CouldNotFindKeyException(
        file: String,
        key: String
) : Exception("Could not find key $key in $file CSV")
