package com.chrrissoft.marvel.framework.chars.datasource

@JvmInline
value class CharsOffset(val value: Int = 0) {
    fun update(value: Int) = CharsOffset(value + 20)
    fun clean() = CharsOffset()
}