package com.chrrissoft.marvel.framework.db

import com.chrrissoft.marvel.data.comics.ComicPreview
import kotlinx.serialization.Serializable

@Serializable
data class ComicPreview(
    override val id: Int,
    override val image: ByteArray,
    override val title: String,
) : ComicPreview {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as com.chrrissoft.marvel.framework.db.ComicPreview

        if (id != other.id) return false
        if (!image.contentEquals(other.image)) return false
        if (title != other.title) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + image.contentHashCode()
        result = 31 * result + title.hashCode()
        return result
    }
}

