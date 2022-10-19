package com.example.musicalartistsapplication.artist_search.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.musicalartistsapplication.common.presentation.model.ArtistsListUiModel
import com.example.musicalartistsapplication.databinding.ItemArtistBinding

class ArtistsAdapter(
    private val onItemClicked: (ArtistsListUiModel.Node) -> Unit
) : ListAdapter<ArtistsListUiModel.Node, ArtistsAdapter.ArtistsViewHolder>(diffUtil) {

    inner class ArtistsViewHolder(private val itemBinding: ItemArtistBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bindArtist(artist: ArtistsListUiModel.Node) {
            itemBinding.apply {
                nameTv.text = artist.name
                disambiguationTv.text = artist.disambiguation
            }
            itemView.setOnClickListener {
                onItemClicked.invoke(artist)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistsViewHolder =
        ArtistsViewHolder(
            ItemArtistBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ArtistsViewHolder, position: Int) {
        holder.bindArtist(getItem(position))
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<ArtistsListUiModel.Node>() {
            override fun areItemsTheSame(
                oldItem: ArtistsListUiModel.Node,
                newItem: ArtistsListUiModel.Node
            ): Boolean = oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: ArtistsListUiModel.Node,
                newItem: ArtistsListUiModel.Node
            ): Boolean = oldItem == newItem
        }
    }
}