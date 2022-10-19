package com.example.musicalartistsapplication.common.presentation.setup.di

import com.example.musicalartistsapplication.common.presentation.mapper.ArtistsListDomainToUiMapper
import com.example.musicalartistsapplication.common.presentation.viewmodel.ArtistsListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val commonPresentationModule = module {

    viewModel {
        ArtistsListViewModel(
            getArtistsListUseCase = get(),
            artistsListDomainToUiMapper = get()
        )
    }
    factory { ArtistsListDomainToUiMapper() }
}