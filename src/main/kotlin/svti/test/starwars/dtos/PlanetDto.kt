package svti.test.starwars.dtos

import java.time.LocalDateTime
import svti.test.starwars.entities.Film
import svti.test.starwars.entities.Person
import svti.test.starwars.entities.Planet

data class PlanetDto(
    val name: String,
    val rotationPeriod: String,
    val orbitalPeriod: String,
    val diameter: String,
    val climate: String,
    val gravity: String,
    val terrain: String,
    val surfaceWater: String,
    val population: String,
    var residents: List<Person>,
    var films: List<Film>,
    val created: LocalDateTime,
    val edited: LocalDateTime,
    val url: String,
) {
    constructor(planet: Planet) : this(
        planet.name,
        planet.rotationPeriod,
        planet.orbitalPeriod,
        planet.diameter,
        planet.climate,
        planet.gravity,
        planet.terrain,
        planet.surfaceWater,
        planet.population,
        emptyList(),
        emptyList(),
        planet.created,
        planet.edited,
        planet.url
    )
}

