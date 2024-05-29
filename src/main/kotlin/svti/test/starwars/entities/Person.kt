package svti.test.starwars.entities

import java.time.LocalDateTime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import svti.test.starwars.util.DateTimeSerializer

@Serializable
data class Person(
    val name: String,
    val height: String,
    val mass: String,
    @SerialName("hair_color")
    val hairColor: String,
    @SerialName("skin_color")
    val skinColor: String,
    @SerialName("eye_color")
    val eyeColor: String,
    @SerialName("birth_year")
    val birthYear: String,
    val gender: String,
    @SerialName("homeworld")
    val homeWorld: String,
    var films: List<String>,
    var species: List<String>,
    var vehicles: List<String>,
    var starships: List<String>,
    @Serializable(with = DateTimeSerializer::class)
    val created: LocalDateTime,
    @Serializable(with = DateTimeSerializer::class)
    val edited: LocalDateTime,
    val url: String,
)
