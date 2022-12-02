package com.chrrissoft.marvel.framework.series.datasource

@JvmInline
value class SeriesOffset(val value: Int = 0) {
    fun update(value: Int) = SeriesOffset(value + 20)
    fun clean() = SeriesOffset()
}