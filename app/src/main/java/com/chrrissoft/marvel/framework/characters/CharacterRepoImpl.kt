package com.chrrissoft.marvel.framework.characters

import android.util.Log
import com.chrrissoft.marvel.data.characters.CharacterDataSource.LocalCharacterDataSource
import com.chrrissoft.marvel.data.characters.CharacterDataSource.RemoteCharacterDataSource
import com.chrrissoft.marvel.data.characters.response.CharacterInfoResponse
import com.chrrissoft.marvel.data.characters.response.CharacterPreviewResponse
import com.chrrissoft.marvel.data.characters.CharactersRepo
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class CharacterRepoImpl @Inject constructor(
    private val remoteDataSource: RemoteCharacterDataSource,
    private val localDataSource: LocalCharacterDataSource,
) : CharactersRepo {

    companion object {
        const val TAG = "CharacterRepoImpl"
    }

    override fun getByIdFromLocale(id: Int): Flow<CharacterInfoResponse> {
        Log.d(TAG, "getting from locale")
        return localDataSource.getById(id)
    }

    override fun getAllFromLocale(): Flow<CharacterPreviewResponse> {
        Log.d(TAG, "getting from locale")
        return localDataSource.getAll()
    }

    override fun getByIdFromRemote(id: Int): Flow<CharacterInfoResponse> {
        Log.d(TAG, "getting from remote")
        return remoteDataSource.getById(id)
    }

    override fun getAllFromRemote(): Flow<CharacterPreviewResponse> {
        Log.d(TAG, "getting from remote")
        return remoteDataSource.getAll()
    }
}