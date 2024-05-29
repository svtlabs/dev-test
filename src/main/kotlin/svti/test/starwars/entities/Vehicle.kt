package svti.test.starwars.entities

import java.time.LocalDateTime
import kotlinx.serialization.SerialName
import svti.test.starwars.util.DateTimeSerializer
import kotlinx.serialization.Serializable

@Serializable
data class Vehicle(
    val name: String,
    val model: String,
    val manufacturer: String,
    @SerialName("cost_in_credits")
    val costInCredits: String,
    val length: String,
    @SerialName("max_atmosphering_speed")
    val maxAtmospheringSpeed: String,
    val crew: String,
    val passengers: String,
    @SerialName("cargo_capacity")
    val cargoCapacity: String,
    val consumables: String,
    @SerialName("vehicle_class")
    val vehicleClass: String,
    var pilots: List<String>,
    var films: List<String>,
    @Serializable(with = DateTimeSerializer::class)
    val created: LocalDateTime,
    @Serializable(with = DateTimeSerializer::class)
    val edited: LocalDateTime,
    val url: String,
)
