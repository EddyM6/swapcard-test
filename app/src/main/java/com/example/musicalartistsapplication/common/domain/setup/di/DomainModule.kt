package com.example.musicalartistsapplication.common.domain.setup.di

import com.example.musicalartistsapplication.common.domain.usecase.GetArtistsListUseCase
import com.example.musicalartistsapplication.common.domain.usecase.impl.GetArtistsListUseCaseImpl
import org.koin.dsl.module

val commonDomainModule = module {

    factory<GetArtistsListUseCase> {
        GetArtistsListUseCaseImpl(
            artistsListRepository = get()
        )
    }
}