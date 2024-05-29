package svti.test.starwars.entities

import java.time.LocalDateTime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import svti.test.starwars.util.DateTimeSerializer

@Serializable
data class Film(
    val title: String,
    @SerialName("episode_id")
    val episodeId: Int,
    @SerialName("opening_crawl")
    val openingCrawl: String,
    val director: String,
    val producer: String,
    @SerialName("release_date")
    val releaseDate: String,
    var characters: List<String>,
    var planets: List<String>,
    var starships: List<String>,
    var vehicles: List<String>,
    var species: List<String>,
    @Serializable(with = DateTimeSerializer::class)
    val created: LocalDateTime,
    @Serializable(with = DateTimeSerializer::class)
    val edited: LocalDateTime,
    val url: String,
)
