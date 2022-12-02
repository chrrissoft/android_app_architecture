package com.chrrissoft.marvel.framework.comics.datasource

@JvmInline
value class ComicsOffset(val value: Int = 0) {
    fun update(value: Int) = ComicsOffset(value + 20)
    fun clean() = ComicsOffset()
}