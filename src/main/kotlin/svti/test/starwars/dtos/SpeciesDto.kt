package svti.test.starwars.dtos

import java.time.LocalDateTime
import svti.test.starwars.entities.Film
import svti.test.starwars.entities.Person
import svti.test.starwars.entities.Species

data class SpeciesDto(
    val name: String,
    val classification: String,
    val designation: String,
    val averageHeight: String,
    val skinColors: String,
    val hairColors: String,
    val eyeColors: String,
    val averageLifespan: String,
    val homeWorld: String?,
    val language: String,
    var people: List<Person>,
    var films: List<Film>,
    val created: LocalDateTime,
    val edited: LocalDateTime,
    val url: String,
) {
    constructor(species: Species) : this(
        species.name,
        species.classification,
        species.designation,
        species.averageHeight,
        species.skinColors,
        species.hairColors,
        species.eyeColors,
        species.averageLifespan,
        species.homeWorld,
        species.language,
        emptyList(),
        emptyList(),
        species.created,
        species.edited,
        species.url
    )
}
