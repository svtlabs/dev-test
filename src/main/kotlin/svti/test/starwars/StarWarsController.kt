package svti.test.starwars

import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import svti.test.starwars.dtos.ApiResponseDto
import svti.test.starwars.dtos.FilmDto
import svti.test.starwars.dtos.PersonDto
import svti.test.starwars.dtos.PlanetDto
import svti.test.starwars.dtos.SpeciesDto
import svti.test.starwars.dtos.StarshipDto
import svti.test.starwars.dtos.VehicleDto

@RestController
@RequestMapping("/api/characters")
@CrossOrigin(origins = ["http://localhost:5173"])
class StarWarsController(private val starWarsService: StarWarsService) {

    @GetMapping
    fun getAllItems(): ApiResponseDto = starWarsService.getAllItems()

    @GetMapping("/people/{id}")
    fun getPersonById(@PathVariable id: String): PersonDto? = starWarsService.getPersonById(id)

    @GetMapping("/films/{id}")
    fun getFilmsById(@PathVariable id: String): FilmDto? = starWarsService.getFilmById(id)

    @GetMapping("/starships/{id}")
    fun getStarshipById(@PathVariable id: String): StarshipDto? = starWarsService.getStarshipById(id)

    @GetMapping("/vehicles/{id}")
    fun getVehicleById(@PathVariable id: String): VehicleDto? = starWarsService.getVehicleById(id)

    @GetMapping("/planets/{id}")
    fun getPlanetById(@PathVariable id: String): PlanetDto? = starWarsService.getPlanetById(id)

    @GetMapping("/species/{id}")
    fun getSpeciesById(@PathVariable id: String): SpeciesDto? = starWarsService.getSpeciesById(id)

}