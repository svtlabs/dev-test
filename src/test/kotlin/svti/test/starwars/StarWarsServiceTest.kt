package svti.test.starwars

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import svti.test.starwars.Characters.FILMS
import svti.test.starwars.Characters.PEOPLE
import svti.test.starwars.Characters.PLANETS
import svti.test.starwars.Characters.SPECIES
import svti.test.starwars.Characters.STARSHIPS
import svti.test.starwars.Characters.VEHICLES

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class StarWarsServiceTest {
    private val service: StarWarsService = StarWarsService()

    @Test
    fun `ensure getAll function returns all the objects`() {
        val allItems = service.getAllItems()

        assertEquals(6, allItems.films.size)
        assertEquals(82, allItems.people.size)
        assertEquals(36, allItems.starships.size)
        assertEquals(39, allItems.vehicles.size)
        assertEquals(60, allItems.planets.size)
    }

    @ParameterizedTest
    @MethodSource("testData")
    fun `ensure getPersonById function returns object of a correct type and has a correct content`(
        key: Characters,
        idString: String,
        expected: String,
    ) {
        when (key) {
            PEOPLE -> {
                val item = service.getPersonById(idString)
                assertNotNull(item)
                assertEquals(expected, item!!.name)
            }

            VEHICLES -> {
                val item = service.getVehicleById(idString)
                assertNotNull(item)
                assertEquals(expected, item!!.name)
            }

            SPECIES -> {
                val item = service.getSpeciesById(idString)
                assertNotNull(item)
                assertEquals(expected, item!!.name)
            }

            STARSHIPS -> {
                val item = service.getStarshipById(idString)
                assertNotNull(item)
                assertEquals(expected, item!!.name)
            }

            FILMS -> {
                val item = service.getFilmById(idString)
                assertNotNull(item)
                assertEquals(expected, item!!.title)
            }

            PLANETS -> {
                val item = service.getPlanetById(idString)
                assertNotNull(item)
                assertEquals(expected, item!!.name)
            }
        }

    }


    private fun testData(): Collection<Array<Any>> {
        return listOf(
            arrayOf(PEOPLE, "1", "Luke Skywalker"),
            arrayOf(PEOPLE, "2", "C-3PO"),
            arrayOf(FILMS, "1", "A New Hope"),
            arrayOf(FILMS, "2", "The Empire Strikes Back"),
            arrayOf(STARSHIPS, "21", "Slave 1"),
            arrayOf(VEHICLES, "4", "Sand Crawler"),
            arrayOf(SPECIES, "15", "Twi'lek"),
            arrayOf(PLANETS, "11", "Geonosis"),
        )
    }
}

