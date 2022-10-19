package com.example.musicalartistsapplication.common.domain.usecase

import com.example.musicalartistsapplication.common.domain.model.ArtistsListDomainModel

interface GetArtistsListUseCase {

    suspend fun execute(
        query: String,
        first: Int,
        after: String?
    ): ArtistsListDomainModel
}