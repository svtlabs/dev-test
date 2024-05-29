package svti.test.starwars.util

import java.io.File
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromJsonElement
import kotlinx.serialization.json.jsonObject
import svti.test.starwars.StarWarsService
import svti.test.starwars.dtos.ApiResponseDto
import svti.test.starwars.dtos.FilmDto

import svti.test.starwars.entities.Film
import svti.test.starwars.entities.Person
import svti.test.starwars.dtos.PersonDto
import svti.test.starwars.dtos.PlanetDto
import svti.test.starwars.dtos.SpeciesDto
import svti.test.starwars.dtos.StarshipDto
import svti.test.starwars.dtos.VehicleDto
import svti.test.starwars.entities.Planet
import svti.test.starwars.entities.Species
import svti.test.starwars.entities.Starship
import svti.test.starwars.entities.Vehicle

class DataJsonParser : StarWarsService() {
    companion object {
        val data: ApiResponseDto
            get() {
                val jsonString = File("src/main/resources/data.json").readText()

                // Parse the JSON string into a JsonObject
                val jsonElement = Json.parseToJsonElement(jsonString).jsonObject

                // Create empty maps to hold the parsed entities
                val people = mutableMapOf<String, Person>()
                val peopleDtos = mutableMapOf<String, PersonDto>()
                val starships = mutableMapOf<String, Starship>()
                val starshipDtos = mutableMapOf<String, StarshipDto>()
                val films = mutableMapOf<String, Film>()
                val filmDtos = mutableMapOf<String, FilmDto>()
                val vehicles = mutableMapOf<String, Vehicle>()
                val vehicleDtos = mutableMapOf<String, VehicleDto>()
                val planets = mutableMapOf<String, Planet>()
                val planetDtos = mutableMapOf<String, PlanetDto>()
                val species = mutableMapOf<String, Species>()
                val speciesDtos = mutableMapOf<String, SpeciesDto>()

                // Iterate over the entries in the JsonObject and parse based on prefix
                for ((key, value) in jsonElement) {
                    try {
                        when {
                            key.startsWith("people/") -> people[key] = Json.decodeFromJsonElement(value.jsonObject)
                            key.startsWith("starships/") -> starships[key] =
                                Json.decodeFromJsonElement(value.jsonObject)

                            key.startsWith("films/") -> films[key] = Json.decodeFromJsonElement(value.jsonObject)
                            key.startsWith("vehicles/") -> vehicles[key] = Json.decodeFromJsonElement(value.jsonObject)
                            key.startsWith("planets/") -> planets[key] = Json.decodeFromJsonElement(value.jsonObject)
                            key.startsWith("species/") -> species[key] = Json.decodeFromJsonElement(value.jsonObject)
                        }
                    } catch (e: Exception) {
                        //TODO add logger
                        println("Failed to parse $key: ${e.message}")
                    }
                }

                setUpObjectValues(
                    people,
                    peopleDtos,
                    films,
                    filmDtos,
                    species,
                    speciesDtos,
                    vehicles,
                    vehicleDtos,
                    starships,
                    starshipDtos,
                    planets,
                    planetDtos
                )

                return ApiResponseDto(peopleDtos, starshipDtos, filmDtos, vehicleDtos, planetDtos, speciesDtos)
            }

        private fun setUpObjectValues(
            people: MutableMap<String, Person>,
            peopleDtos: MutableMap<String, PersonDto>,
            films: MutableMap<String, Film>,
            filmDtos: MutableMap<String, FilmDto>,
            species: MutableMap<String, Species>,
            speciesDtos: MutableMap<String, SpeciesDto>,
            vehicles: MutableMap<String, Vehicle>,
            vehicleDtos: MutableMap<String, VehicleDto>,
            starships: MutableMap<String, Starship>,
            starshipDtos: MutableMap<String, StarshipDto>,
            planets: MutableMap<String, Planet>,
            planetDtos: MutableMap<String, PlanetDto>,
        ) {
            people.forEach { (key, person) ->
                val dto = PersonDto(person)
                dto.films = person.films.mapNotNull { films[it] }.map { it }
                dto.species = person.species.mapNotNull { species[it] }.map { it }
                dto.vehicles = person.vehicles.mapNotNull { vehicles[it] }.map { it }
                peopleDtos[key] = dto
            }

            starships.forEach { (key, starship) ->
                val dto = StarshipDto(starship)
                dto.pilots = starship.pilots.mapNotNull { people[it] }.map { it }
                dto.films = starship.films.mapNotNull { films[it] }.map { it }
                starshipDtos[key] = dto
            }

            vehicles.forEach { (key, vehicle) ->
                val dto = VehicleDto(vehicle)
                dto.pilots = vehicle.pilots.mapNotNull { people[it] }.map { it }
                dto.films = vehicle.films.mapNotNull { films[it] }.map { it }
                vehicleDtos[key] = dto
            }

            species.forEach { (key, species) ->
                val dto = SpeciesDto(species)
                dto.films = species.films.mapNotNull { films[it] }.map { it }
                dto.people = species.films.mapNotNull { people[it] }.map { it }
                speciesDtos[key] = dto
            }

            planets.forEach { (key, planets) ->
                val dto = PlanetDto(planets)
                dto.films = planets.films.mapNotNull { films[it] }.map { it }
                dto.residents = planets.films.mapNotNull { people[it] }.map { it }
                planetDtos[key] = dto
            }

            films.forEach { (key, film) ->
                val dto = FilmDto(film)
                dto.characters = film.characters.mapNotNull { people[it] }.map { it }
                dto.planets = film.planets.mapNotNull { planets[it] }.map { it }
                dto.starships = film.starships.mapNotNull { starships[it] }.map { it }
                dto.vehicles = film.vehicles.mapNotNull { vehicles[it] }.map { it }
                dto.species = film.species.mapNotNull { species[it] }.map { it }
                filmDtos[key] = dto
            }
        }
    }


}