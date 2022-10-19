package com.example.musicalartistsapplication.common.domain.usecase.impl

import com.example.musicalartistsapplication.common.domain.model.ArtistsListDomainModel
import com.example.musicalartistsapplication.common.domain.repository.ArtistsListRepository
import com.example.musicalartistsapplication.common.domain.usecase.GetArtistsListUseCase

class GetArtistsListUseCaseImpl(
    private val artistsListRepository: ArtistsListRepository
) : GetArtistsListUseCase {

    override suspend fun execute(
        query: String,
        first: Int,
        after: String?
    ): ArtistsListDomainModel = artistsListRepository.getRemoteArtistsList(
        query = query,
        first = first,
        after = after
    )
}