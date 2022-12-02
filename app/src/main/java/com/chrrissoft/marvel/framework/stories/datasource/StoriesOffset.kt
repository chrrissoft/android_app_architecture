package com.chrrissoft.marvel.framework.stories.datasource

@JvmInline
value class StoriesOffset(val value: Int = 0) {
    fun update(value: Int) = StoriesOffset(value + 20)
    fun clean() = StoriesOffset()
}