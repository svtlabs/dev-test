package svti.test.starwars.dtos

import java.time.LocalDateTime
import svti.test.starwars.entities.Film
import svti.test.starwars.entities.Person
import svti.test.starwars.entities.Species
import svti.test.starwars.entities.Starship
import svti.test.starwars.entities.Vehicle

data class PersonDto(
    val name: String,
    val height: String,
    val mass: String,
    val hairColor: String,
    val skinColor: String,
    val eyeColor: String,
    val birthYear: String,
    val gender: String,
    val homeWorld: String,
    var films: List<Film>,
    var species: List<Species>,
    var vehicles: List<Vehicle>,
    var starships: List<Starship>,
    val created: LocalDateTime,
    val edited: LocalDateTime,
    val url: String,
) {
    constructor(person: Person) : this(
        person.name,
        person.height,
        person.mass,
        person.eyeColor,
        person.skinColor,
        person.hairColor,
        person.birthYear,
        person.gender,
        person.homeWorld,
        emptyList(),
        emptyList(),
        emptyList(),
        emptyList(),
        person.created,
        person.edited,
        person.url
    )
}
