package svti.test.starwars.dtos


data class ApiResponseDto(
    val people: Map<String, PersonDto>,
    val starships: MutableMap<String, StarshipDto>,
    val films: Map<String, FilmDto>,
    val vehicles: MutableMap<String, VehicleDto>,
    val planets: Map<String, PlanetDto>,
    val species: MutableMap<String, SpeciesDto>,
)