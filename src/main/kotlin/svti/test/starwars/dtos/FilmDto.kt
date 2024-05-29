package svti.test.starwars.dtos

import java.time.LocalDateTime
import svti.test.starwars.entities.Film
import svti.test.starwars.entities.Person
import svti.test.starwars.entities.Planet
import svti.test.starwars.entities.Species
import svti.test.starwars.entities.Starship
import svti.test.starwars.entities.Vehicle

data class FilmDto(
    val title: String,
    val episodeId: Int,
    val openingCrawl: String,
    val director: String,
    val producer: String,
    val releaseDate: String,
    var characters: List<Person>,
    var planets: List<Planet>,
    var starships: List<Starship>,
    var vehicles: List<Vehicle>,
    var species: List<Species>,
    val created: LocalDateTime,
    val edited: LocalDateTime,
    val url: String,
) {
    constructor(film: Film) : this(
        film.title,
        film.episodeId,
        film.openingCrawl,
        film.director,
        film.producer,
        film.releaseDate,
        emptyList(),
        emptyList(),
        emptyList(),
        emptyList(),
        emptyList(),
        film.created,
        film.edited,
        film.url
    )
}
