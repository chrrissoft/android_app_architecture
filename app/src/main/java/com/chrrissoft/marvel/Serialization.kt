package com.chrrissoft.marvel

import kotlinx.serialization.*
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.encoding.encodeStructure
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.encodeToJsonElement

@Serializable
class Serialization

fun main() {
    val json = Json.encodeToJsonElement(Serialization.serializer(), Serialization())
    val json1 = Json.encodeToJsonElement(serializer(), Serialization())
    val json2 = Json.encodeToJsonElement(Serialization)

    val ser0 = Serialization
    val ser1 = Serialization
    val list: KSerializer<List<Serialization>> = ListSerializer(ser0.serializer())

    val string = Json.encodeToString(Serialization.serializer(), Serialization())
    val string2 = Json.encodeToString(Serialization) // experimental
}

class MySerial : KSerializer<Serialization> {

    override fun deserialize(decoder: Decoder): Serialization {
        return decoder.decodeSerializableValue(Json.decodeFromString(""))
    }

    override val descriptor: SerialDescriptor
        get() = TODO("Not yet implemented")

    override fun serialize(encoder: Encoder, value: Serialization) {
        encoder.encodeStructure(descriptor) {
            encodeBooleanElement(descriptor, 1, value.hashCode() == 12)
        }

    }
}