package svti.test.starwars.entities

import java.time.LocalDateTime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import svti.test.starwars.util.DateTimeSerializer

@Serializable
data class Species(
    val name: String,
    val classification: String,
    val designation: String,
    @SerialName("average_height")
    val averageHeight: String,
    @SerialName("skin_colors")
    val skinColors: String,
    @SerialName("hair_colors")
    val hairColors: String,
    @SerialName("eye_colors")
    val eyeColors: String,
    @SerialName("average_lifespan")
    val averageLifespan: String,
    @SerialName("homeworld")
    val homeWorld: String?,
    val language: String,
    var people: List<String>,
    var films: List<String>,
    @Serializable(with = DateTimeSerializer::class)
    val created: LocalDateTime,
    @Serializable(with = DateTimeSerializer::class)
    val edited: LocalDateTime,
    val url: String,
)
