package com.chrrissoft.marvel.usecases.characters

import com.chrrissoft.marvel.data.characters.CharactersRepo
import javax.inject.Inject

class GetCharacterInfoUseCase @Inject constructor(
    private val repo: CharactersRepo,
) {
    suspend operator fun invoke(
        id: Int
    ) {
    }
}

