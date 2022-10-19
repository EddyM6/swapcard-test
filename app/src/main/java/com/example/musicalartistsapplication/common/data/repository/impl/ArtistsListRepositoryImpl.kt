package com.example.musicalartistsapplication.common.data.repository.impl

import com.example.musicalartistsapplication.common.data.datasource.remote.ArtistsListRemoteDataSource
import com.example.musicalartistsapplication.common.data.mapper.ArtistsListDataToDomainMapper
import com.example.musicalartistsapplication.common.domain.model.ArtistsListDomainModel
import com.example.musicalartistsapplication.common.domain.repository.ArtistsListRepository

class ArtistsListRepositoryImpl(
    private val artistsListRemoteDataSource: ArtistsListRemoteDataSource,
    private val artistsListDataToDomainMapper: ArtistsListDataToDomainMapper
) : ArtistsListRepository {

    override suspend fun getRemoteArtistsList(
        query: String,
        first: Int,
        after: String?
    ): ArtistsListDomainModel = artistsListDataToDomainMapper.map(
        artistsListRemoteDataSource.getArtistsList(
            query = query,
            first = first,
            after = after
        )
    )
}