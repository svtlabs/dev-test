package svti.test.starwars.dtos

import java.time.LocalDateTime
import svti.test.starwars.entities.Film
import svti.test.starwars.entities.Person
import svti.test.starwars.entities.Starship

data class StarshipDto(
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
    val hyperdriveRating: String,
    val mglt: String,
    val starshipClass: String,
    var pilots: List<Person>,
    var films: List<Film>,
    val created: LocalDateTime,
    val edited: LocalDateTime,
    val url: String,
) {
    constructor(starship: Starship) : this(
        starship.name,
        starship.model,
        starship.manufacturer,
        starship.costInCredits,
        starship.length,
        starship.maxAtmospheringSpeed,
        starship.crew,
        starship.passengers,
        starship.cargoCapacity,
        starship.consumables,
        starship.hyperdriveRating,
        starship.mglt,
        starship.starshipClass,
        emptyList(),
        emptyList(),
        starship.created,
        starship.edited,
        starship.url
    )
}
