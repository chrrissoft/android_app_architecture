package com.chrrissoft.marvel.ui.characters

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import coil.compose.AsyncImage
import com.chrrissoft.marvel.ui.characters.state.preview.CharacterPreview

@Composable
fun CharactersScreen(
    viewModel: CharacterViewModel
) {
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getChars()
    }

    CharsList(uiState.characters) {
        viewModel.getCharInfo(it)
    }
}

@Composable
fun CharsList(
    list: List<CharacterPreview>,
    onClick: (Int) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(list) {
            Row(
                modifier = Modifier.clickable { onClick(it.id) }
            ) {
                Text(it.name, color = Color.Red)
                AsyncImage(model = it.thumbnail, contentDescription = null)
            }
        }
    }
}