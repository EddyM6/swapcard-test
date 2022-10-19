package com.example.musicalartistsapplication.common.data.datasource.remote

import com.example.musicalartistsapplication.common.data.model.ArtistsListDataModel

interface ArtistsListRemoteDataSource {

    suspend fun getArtistsList(query: String, first: Int, after: String?): ArtistsListDataModel
}