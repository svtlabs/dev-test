package svti.test.starwars

import org.springframework.stereotype.Service
import svti.test.starwars.dtos.ApiResponseDto
import svti.test.starwars.dtos.FilmDto
import svti.test.starwars.dtos.PersonDto
import svti.test.starwars.dtos.PlanetDto
import svti.test.starwars.dtos.SpeciesDto
import svti.test.starwars.dtos.StarshipDto
import svti.test.starwars.dtos.VehicleDto
import svti.test.starwars.util.DataJsonParser

@Service
class StarWarsService {
    final val data = DataJsonParser.data

    fun getAllItems(): ApiResponseDto {
        return ApiResponseDto(
            data.people,
            data.starships,
            data.films,
            data.vehicles,
            data.planets,
            data.species
        )
    }

    fun getPersonById(id: String): PersonDto? {
        return data.people["people/$id"]
    }

    fun getFilmById(id: String): FilmDto? {
        return data.films["films/$id"]
    }

    fun getStarshipById(id: String): StarshipDto? {
        return data.starships["starships/$id"]
    }

    fun getVehicleById(id: String): VehicleDto? {
        return data.vehicles["vehicles/$id"]
    }

    fun getPlanetById(id: String): PlanetDto? {
        return data.planets["planets/$id"]
    }

    fun getSpeciesById(id: String): SpeciesDto? {
        return data.species["species/$id"]
    }

}
