import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

data class Film(
    @SerializedName("title") val title: String,
    @SerializedName("release_year") val releaseYear: Int,
    @SerializedName("country") val country: String
)

class JsonConverter {
    private val gson = Gson()

    fun toJson(film: Film): String = gson.toJson(film)
    fun fromJson(json: String): Film = gson.fromJson(json, Film::class.java)
}

class Test {
    private val converter = JsonConverter()

    @Test
    fun serialize() {
        val film = Film("Непрощенный", 1992, "США")
        val json = converter.toJson(film)
        assertEquals("""{"title":"Непрощенный","release_year":1992,"country":"США"}""", json)
        println("Cериализация:")
        println("Input: $film:")
        println("Output: $json:")
        println()
    }

    @Test
    fun deserialize() {
        val json = """{"title":"Непрощенный","release_year":1992,"country":"США"}"""
        val film = converter.fromJson(json)
        assertEquals(Film("Непрощенный", 1992, "США"), film)
        println("Десериализация:")
        println("Input: $json:")
        println("Output: $film:")
        println()
    }
}