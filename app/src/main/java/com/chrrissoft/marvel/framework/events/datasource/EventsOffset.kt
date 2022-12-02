package com.chrrissoft.marvel.framework.events.datasource

@JvmInline
value class EventsOffset(val value: Int = 0) {
    fun update(value: Int) = EventsOffset(value + 20)
    fun clean() = EventsOffset()
}