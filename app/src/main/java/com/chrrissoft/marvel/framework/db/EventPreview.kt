package com.chrrissoft.marvel.framework.db

import kotlinx.serialization.Serializable
import com.chrrissoft.marvel.data.events.EventPreview

@Serializable
data class EventPreview(
    override val id: Int,
    override val title: String,
    override val image: ByteArray,
) : EventPreview {


    override fun hashCode(): Int {
        var result = title.hashCode()
        result = 31 * result + image.contentHashCode()
        return result
    }

    override fun convertImage(): Any? {
        return null
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as com.chrrissoft.marvel.framework.db.EventPreview

        if (id != other.id) return false
        if (title != other.title) return false
        if (!image.contentEquals(other.image)) return false

        return true
    }
}