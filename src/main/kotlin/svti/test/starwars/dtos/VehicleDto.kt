package svti.test.starwars.dtos

import java.time.LocalDateTime
import svti.test.starwars.entities.Film
import svti.test.starwars.entities.Person
import svti.test.starwars.entities.Vehicle

data class VehicleDto(
    val name: String,
    val model: String,
    val manufacturer: String,
    val costInCredits: String,
    val length: String,
    val maxAtmospheringSpeed: String,
    val crew: String,
    val passengers: String,
    val cargoCapacity: String,
    val consumables: String,
    val vehicleClass: String,
    var pilots: List<Person>,
    var films: List<Film>,
    val created: LocalDateTime,
    val edited: LocalDateTime,
    val url: String,
) {
    constructor(vehicle: Vehicle) : this(
        vehicle.name,
        vehicle.model,
        vehicle.manufacturer,
        vehicle.costInCredits,
        vehicle.length,
        vehicle.maxAtmospheringSpeed,
        vehicle.crew,
        vehicle.passengers,
        vehicle.cargoCapacity,
        vehicle.consumables,
        vehicle.vehicleClass,
        emptyList(),
        emptyList(),
        vehicle.created,
        vehicle.edited,
        vehicle.url

    )
}
