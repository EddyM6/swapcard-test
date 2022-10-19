package com.example.musicalartistsapplication.common.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.musicalartistsapplication.common.domain.usecase.GetArtistsListUseCase
import com.example.musicalartistsapplication.common.presentation.mapper.ArtistsListDomainToUiMapper
import com.example.musicalartistsapplication.common.presentation.model.ArtistsListUiModel
import com.example.musicalartistsapplication.common.presentation.setup.util.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistsListViewModel(
    private val getArtistsListUseCase: GetArtistsListUseCase,
    private val artistsListDomainToUiMapper: ArtistsListDomainToUiMapper
) : BaseViewModel() {
    private var currentName = ""
    private var endCursor = ""
    private var hasNextPage = false
    private var lastListSize = 0
    private var artistsList: MutableList<ArtistsListUiModel.Node?> = mutableListOf()
    private val _artistsLiveData = MutableLiveData<List<ArtistsListUiModel.Node?>>()
    val artistsLiveData: LiveData<List<ArtistsListUiModel.Node?>> = _artistsLiveData


    fun getArtistsList(name: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = getArtistsListUseCase.execute(
                query = name,
                first = 15,
                after = null
            )
            artistsList.clear()
            artistsListDomainToUiMapper.map(response).nodes?.forEach {
                artistsList.add(it)
            }
            currentName = name
            endCursor = response.pageInfo?.endCursor ?: ""
            hasNextPage = response.pageInfo?.hasNextPage ?: false
            _artistsLiveData.postValue(
                artistsList
            )
        }
    }

    fun loadMoreItemsIfExist(listSize: Int) {
        if (listSize != lastListSize) {
            lastListSize = listSize
            if (hasNextPage) {
                viewModelScope.launch(Dispatchers.IO) {
                    val response = getArtistsListUseCase.execute(
                        query = currentName,
                        first = 15,
                        after = endCursor
                    )
                    Log.e("loadMoreItems", response.toString())
                    artistsListDomainToUiMapper.map(response).nodes?.forEach {
                        artistsList.add(it)
                    }
                    endCursor = response.pageInfo?.endCursor ?: ""
                    hasNextPage = response.pageInfo?.hasNextPage ?: false
                    _artistsLiveData.postValue(
                        artistsList
                    )
                }
            }
        }
    }
}