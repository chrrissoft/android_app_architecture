package com.chrrissoft.marvel.framework.characters.datasource

import com.chrrissoft.marvel.data.characters.CharacterDataSource.LocalCharacterDataSource
import com.chrrissoft.marvel.data.characters.response.CharacterInfoResponse
import com.chrrissoft.marvel.data.characters.response.CharacterPreviewResponse.LocalCharacterPreviewResponse
import com.chrrissoft.marvel.framework.characters.database.info.CharacterInfoDao
import com.chrrissoft.marvel.framework.characters.database.preview.CharacterPreviewDao
import com.chrrissoft.marvel.framework.characters.response.info.local.LocalInfoError
import com.chrrissoft.marvel.framework.characters.response.info.local.LocalInfoLoading
import com.chrrissoft.marvel.framework.characters.response.info.local.RoomCharacterInfoResponse
import com.chrrissoft.marvel.framework.characters.response.preview.local.LocalPreviewError
import com.chrrissoft.marvel.framework.characters.response.preview.local.LocalPreviewLoading
import com.chrrissoft.marvel.framework.characters.response.preview.local.RoomCharacterPreviewResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LocalCharacterDataSourceImpl @Inject constructor(
    private val daoInfo: CharacterInfoDao,
    private val daoPrev: CharacterPreviewDao
) : LocalCharacterDataSource {

    override fun getById(id: Int): Flow<CharacterInfoResponse> {
        return flow {
            emit(LocalInfoLoading)
            daoInfo.getById(id)
                .catch { emit(LocalInfoError) }
                .collect { emit(RoomCharacterInfoResponse(it)) }
        }
    }

    override fun getAll(): Flow<LocalCharacterPreviewResponse> {
        return flow {
            emit(LocalPreviewLoading)
            daoPrev.getAll().catch { emit(LocalPreviewError) }
                .collect { emit(RoomCharacterPreviewResponse(it)) }
        }
    }
}






