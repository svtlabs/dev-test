package svti.test.starwars.entities

import java.time.LocalDateTime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import svti.test.starwars.util.DateTimeSerializer

@Serializable
data class Planet(
    val name: String,
    @SerialName("rotation_period")
    val rotationPeriod: String,
    @SerialName("orbital_period")
    val orbitalPeriod: String,
    val diameter: String,
    val climate: String,
    val gravity: String,
    val terrain: String,
    @SerialName("surface_water")
    val surfaceWater: String,
    val population: String,
    var residents: List<String>,
    var films: List<String>,
    @Serializable(with = DateTimeSerializer::class)
    val created: LocalDateTime,
    @Serializable(with = DateTimeSerializer::class)
    val edited: LocalDateTime,
    val url: String,
)
