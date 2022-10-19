package com.example.musicalartistsapplication.artist_search.presentation.screen

import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.musicalartistsapplication.R
import com.example.musicalartistsapplication.artist_search.presentation.adapter.ArtistsAdapter
import com.example.musicalartistsapplication.common.presentation.model.ArtistsListUiModel
import com.example.musicalartistsapplication.common.presentation.setup.util.BaseFragment
import com.example.musicalartistsapplication.common.presentation.setup.util.viewBinding
import com.example.musicalartistsapplication.common.presentation.viewmodel.ArtistsListViewModel
import com.example.musicalartistsapplication.core.extension.d
import com.example.musicalartistsapplication.databinding.FragmentArtistSearchBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ArtistSearchFragment : BaseFragment(R.layout.fragment_artist_search) {
    private val binding by viewBinding(FragmentArtistSearchBinding::bind)
    private val artistsListViewModel: ArtistsListViewModel by viewModel()
    private val artistsAdapter: ArtistsAdapter by lazy {
        ArtistsAdapter(
            ::onItemClicked
        )
    }

    override fun setupView() {
        binding.apply {
            searchBtn.setOnClickListener(::onSearchButtonClicked)
        }
        setupObservers()
        setupRecyclerView()
    }

    private fun onSearchButtonClicked(view: View) {
        binding.searchEt.apply {
            if (text.isNotEmpty())
                artistsListViewModel.getArtistsList(
                    name = text.toString()
                )
        }
    }

    private fun onItemClicked(data: ArtistsListUiModel.Node) {
        findNavController().navigate(
            ArtistSearchFragmentDirections.actionArtistsListFragmentToArtistDetailsFragment(
                name = data.name ?: "null",
                disambiguation = data.disambiguation ?: "null",
                type = data.type ?: "null",
                country = data.country ?: "null",
                rating = (data.rating?.value ?: 0.0).toFloat(),
                votes = data.rating?.voteCount ?: 0
            )
        )
    }

    private fun setupRecyclerView() {
        val manager = LinearLayoutManager(activity)

        binding.artistsRv.apply {
            adapter = artistsAdapter
            layoutManager = manager
        }
        setRecyclerViewScrollListener(manager)
    }

    private fun setRecyclerViewScrollListener(manager: LinearLayoutManager) {
        binding.artistsRv.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (manager.findLastCompletelyVisibleItemPosition() > manager.itemCount - 10) {
                    artistsListViewModel.loadMoreItemsIfExist(manager.itemCount)
                }
            }
        })
    }

    private fun setupObservers() {
        artistsListViewModel.artistsLiveData.observe(this) {
            artistsAdapter.submitList(it.toMutableList())
        }
    }
}