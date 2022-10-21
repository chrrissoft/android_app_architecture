package com.chrrissoft.marvel.framework.characters.datasource

import com.chrrissoft.marvel.data.characters.CharacterDataSource.RemoteCharacterDataSource
import com.chrrissoft.marvel.data.characters.response.CharacterInfoResponse.RemoteCharacterInfoResponse
import com.chrrissoft.marvel.data.characters.response.CharacterPreviewResponse.RemoteCharacterPreviewResponse
import com.chrrissoft.marvel.framework.characters.CharacterAPIService
import com.chrrissoft.marvel.framework.characters.models.info.CharacterInfo
import com.chrrissoft.marvel.framework.characters.response.info.remote.ApiCharacterInfoResponse
import com.chrrissoft.marvel.framework.characters.response.info.remote.ApiInfoError
import com.chrrissoft.marvel.framework.characters.response.info.remote.ApiInfoLoading
import com.chrrissoft.marvel.framework.characters.response.preview.remote.ApiCharacterPreviewResponse
import com.chrrissoft.marvel.framework.characters.response.preview.remote.ApiPreviewError
import com.chrrissoft.marvel.framework.characters.response.preview.remote.ApiPreviewLoading
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RemoteCharacterDataSourceImp @Inject constructor(
    private val characterAPIService: CharacterAPIService
) : RemoteCharacterDataSource {

    override fun getById(id: Int): Flow<RemoteCharacterInfoResponse> {
        return flow {
            try {
                emit(ApiInfoLoading)
                emit(
                    ApiCharacterInfoResponse(
                        characterAPIService
                            .getById(id).body()
                            ?.data?.results
                            ?.first() ?: CharacterInfo()
                    )
                )
            } catch (e: Exception) {
                emit(ApiInfoError)
            }
        }
    }

    override fun getAll(): Flow<RemoteCharacterPreviewResponse> {
        return flow {
            try {
                emit(ApiPreviewLoading)
                emit(
                    ApiCharacterPreviewResponse(
                        prev = characterAPIService.getAll().body()
                            ?.data?.results ?: emptyList()
                    )
                )
            } catch (e: Exception) {
                emit(ApiPreviewError)
            }
        }
    }

}