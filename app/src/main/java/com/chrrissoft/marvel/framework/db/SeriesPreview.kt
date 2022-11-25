package com.chrrissoft.marvel.framework.db

import com.chrrissoft.marvel.data.series.SeriesPreview
import kotlinx.serialization.Serializable

@Serializable
data class SeriesPreview(
    override val id: Int,
    override val title: String,
    override val image: ByteArray,
) : SeriesPreview {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as com.chrrissoft.marvel.framework.db.SeriesPreview

        if (title != other.title) return false
        if (!image.contentEquals(other.image)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = title.hashCode()
        result = 31 * result + image.contentHashCode()
        return result
    }
}