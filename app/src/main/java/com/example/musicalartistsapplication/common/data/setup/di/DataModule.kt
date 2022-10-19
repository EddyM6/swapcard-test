package com.example.musicalartistsapplication.common.data.setup.di

import com.apollographql.apollo3.ApolloClient
import com.example.musicalartistsapplication.BuildConfig
import com.example.musicalartistsapplication.common.data.datasource.remote.ArtistsListRemoteDataSource
import com.example.musicalartistsapplication.common.data.datasource.remote.impl.ArtistsListRemoteDataSourceImpl
import com.example.musicalartistsapplication.common.data.mapper.ArtistsListDataToDomainMapper
import com.example.musicalartistsapplication.common.data.mapper.ArtistsListResponseToDataMapper
import com.example.musicalartistsapplication.common.data.repository.impl.ArtistsListRepositoryImpl
import com.example.musicalartistsapplication.common.domain.repository.ArtistsListRepository
import org.koin.dsl.module

val commonDataModule = module {

    factory<ArtistsListRemoteDataSource> {
        ArtistsListRemoteDataSourceImpl(
            apolloClient = get(),
            artistsListResponseToDataMapper = get()
        )
    }
    single {
        ApolloClient.Builder()
            .serverUrl(BuildConfig.BASE_URL)
            .build()
    }
    factory { ArtistsListResponseToDataMapper() }


    factory<ArtistsListRepository> {
        ArtistsListRepositoryImpl(
            artistsListRemoteDataSource = get(),
            artistsListDataToDomainMapper = get()
        )
    }
    factory { ArtistsListDataToDomainMapper() }
}