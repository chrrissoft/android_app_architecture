package com.chrrissoft.marvel.ui.navigation

sealed class Screens(val route: String) {

    object CharsScreen : Screens("chars")
    object ComicsScreen : Screens("comics")
    object EventsScreen : Screens("events")
    object SeriesScreen : Screens("series")
    object StoriesScreen : Screens("stories")

}