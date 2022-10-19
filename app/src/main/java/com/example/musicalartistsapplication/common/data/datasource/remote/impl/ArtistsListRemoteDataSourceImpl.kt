package com.example.musicalartistsapplication.common.data.datasource.remote.impl

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.Optional
import com.example.musicalartistsapp.GetSearchResultQuery
import com.example.musicalartistsapplication.common.data.datasource.remote.ArtistsListRemoteDataSource
import com.example.musicalartistsapplication.common.data.mapper.ArtistsListResponseToDataMapper
import com.example.musicalartistsapplication.common.data.model.ArtistsListDataModel

class ArtistsListRemoteDataSourceImpl(
    private val apolloClient: ApolloClient,
    private val artistsListResponseToDataMapper: ArtistsListResponseToDataMapper
) : ArtistsListRemoteDataSource {

    override suspend fun getArtistsList(
        query: String,
        first: Int,
        after: String?
    ): ArtistsListDataModel = artistsListResponseToDataMapper.map(
        apolloClient.query(
            GetSearchResultQuery(
                query = query,
                first = Optional.present(first),
                after = Optional.present(after)
            )
        ).execute()
    )
}