package com.chrrissoft.marvel.framework.db

import kotlinx.serialization.Serializable

@Serializable
data class CharacterPreview(
    val name: String,
    val image: ByteArray? = null
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CharacterPreview

        if (name != other.name) return false
        if (image != null) {
            if (other.image == null) return false
            if (!image.contentEquals(other.image)) return false
        } else if (other.image != null) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + (image?.contentHashCode() ?: 0)
        return result
    }
}
