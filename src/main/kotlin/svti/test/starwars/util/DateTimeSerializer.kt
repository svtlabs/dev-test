package svti.test.starwars.util

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializer
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@OptIn(ExperimentalSerializationApi::class)
@Serializer(forClass = LocalDateTime::class)
object DateTimeSerializer {
    private val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS")

    override fun serialize(encoder: Encoder, value: LocalDateTime) {
        encoder.encodeString(value.format(formatter))
    }


    override fun deserialize(decoder: Decoder): LocalDateTime {
        val dateString = decoder.decodeString().replace('T', ' ').replace('Z', ' ').trim()
        try {
            return LocalDateTime.parse(dateString, formatter)
        } catch (e: Exception) {
            val format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
            return LocalDateTime.parse(dateString, format)
        }
    }
}
