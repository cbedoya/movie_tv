package com.weathergroup.core.network.model.util

import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.atStartOfDayIn
import kotlinx.datetime.toInstant
import kotlinx.datetime.toLocalDate
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

object InstantSerializer : KSerializer<Instant> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor(serialName = "Instant", kind = PrimitiveKind.STRING)

    override fun deserialize(decoder: Decoder): Instant = decoder.decodeString().toLocalDate().atStartOfDayIn(
        TimeZone.currentSystemDefault())

    override fun serialize(encoder: Encoder, value: Instant) =
        encoder.encodeString(value.toString())
}