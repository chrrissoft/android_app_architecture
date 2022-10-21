package com.chrrissoft.marvel.ui.characters.state.info

data class CharacterInfo(
    val id: Int = 0,
    val name: String = "",
    val description: String = "",
    val thumbnail: Any = "",
    val comics: Comics? = Comics(),
    val series: Series? = Series(),
    val stories: Stories? = Stories(),
    val events: Events? = Events(),
)

