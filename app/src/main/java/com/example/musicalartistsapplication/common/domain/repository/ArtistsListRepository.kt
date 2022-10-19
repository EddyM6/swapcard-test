package com.example.musicalartistsapplication.common.domain.repository

import com.example.musicalartistsapplication.common.domain.model.ArtistsListDomainModel

interface ArtistsListRepository {

    suspend fun getRemoteArtistsList(
        query: String,
        first: Int,
        after: String?
    ): ArtistsListDomainModel
}