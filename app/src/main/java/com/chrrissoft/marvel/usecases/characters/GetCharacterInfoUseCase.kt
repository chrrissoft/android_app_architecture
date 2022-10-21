package com.chrrissoft.marvel.usecases.characters

import com.chrrissoft.marvel.data.characters.CharactersRepo
import com.chrrissoft.marvel.data.netstate.NetState
import com.chrrissoft.marvel.ui.characters.state.info.CharacterInfo
import javax.inject.Inject

class GetCharacterInfoUseCase @Inject constructor(
    private val repo: CharactersRepo,
) {
    suspend operator fun invoke(
        id: Int
    ): CharacterInfo {
        var completeChar = CharacterInfo()
        return completeChar
    }
}

