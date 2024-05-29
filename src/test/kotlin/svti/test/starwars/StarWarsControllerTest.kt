package svti.test.starwars

import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import io.mockk.junit5.MockKExtension
import java.time.LocalDateTime
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import svti.test.starwars.dtos.ApiResponseDto
import svti.test.starwars.dtos.FilmDto
import svti.test.starwars.dtos.PersonDto
import svti.test.starwars.dtos.PlanetDto
import svti.test.starwars.dtos.SpeciesDto
import svti.test.starwars.dtos.StarshipDto
import svti.test.starwars.dtos.VehicleDto

@WebMvcTest
class StarWarsControllerTest(
    @Autowired val mockMvc: MockMvc,
) {

    @MockkBean
    lateinit var starWarsService: StarWarsService

    @BeforeEach
    fun before() {
        every { starWarsService.getAllItems() } returns createApiResponse()

    }

    @Test
    fun getAllItems() {
        val id = "people/1"
        mockMvc.perform(get("/api/characters"))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.people.$id.name").value("name"))
    }

    @Test
    @ExtendWith(MockKExtension::class)
    fun getItemById() {
        val id = "people/1"
        mockMvc.perform(get("/api/characters?$id"))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.people.$id.name").value("name"))
    }

    private fun createTestPerson() = PersonDto(
        "name",
        "149",
        "55",
        "red",
        "red",
        "red",
        "1000000",
        "n/a",
        "test",
        emptyList(),
        emptyList(),
        emptyList(),
        emptyList(),
        LocalDateTime.now(),
        LocalDateTime.now(),
        "people/1",
    )

    private fun createTestFilm() = FilmDto(
        "title",
        1,
        "",
        "",
        "",
        "",
        emptyList(),
        emptyList(),
        emptyList(),
        emptyList(),
        emptyList(),
        LocalDateTime.now(),
        LocalDateTime.now(),
        "films/1",
    )

    private fun createTestStarship() = StarshipDto(
        "title",
        "episodeId",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        emptyList(),
        emptyList(),
        LocalDateTime.now(),
        LocalDateTime.now(),
        "starships/1",
    )

    private fun createTestVehicle() = VehicleDto(
        "title",
        "episodeId",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        emptyList(),
        emptyList(),
        LocalDateTime.now(),
        LocalDateTime.now(),
        "vehicles/1",
    )

    private fun createTestSpecies() = SpeciesDto(
        "title",
        "episodeId",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        emptyList(),
        emptyList(),
        LocalDateTime.now(),
        LocalDateTime.now(),
        "vehicles/1",
    )

    private fun createTestPlanet() = PlanetDto(
        "title",
        "episodeId",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        emptyList(),
        emptyList(),
        LocalDateTime.now(),
        LocalDateTime.now(),
        "planets/1",
    )

    private fun createApiResponse(): ApiResponseDto {
        val person = createTestPerson()
        val starship = createTestStarship()
        val film = createTestFilm()
        val vehicle = createTestVehicle()
        val species = createTestSpecies()
        val planet = createTestPlanet()

        return ApiResponseDto(
            hashMapOf("people/1" to person),
            hashMapOf("starships/1" to starship),
            hashMapOf("films/1" to film),
            hashMapOf("vehicles/1" to vehicle),
            hashMapOf("planets/1" to planet),
            hashMapOf("species/1" to species),
        )
    }
}