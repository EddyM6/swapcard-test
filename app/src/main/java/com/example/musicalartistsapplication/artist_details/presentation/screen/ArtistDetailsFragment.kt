package com.example.musicalartistsapplication.artist_details.presentation.screen

import android.annotation.SuppressLint
import androidx.navigation.fragment.navArgs
import com.example.musicalartistsapplication.R
import com.example.musicalartistsapplication.common.presentation.setup.util.BaseFragment
import com.example.musicalartistsapplication.common.presentation.setup.util.viewBinding
import com.example.musicalartistsapplication.databinding.FragmentArtistDetailsBinding

class ArtistDetailsFragment : BaseFragment(R.layout.fragment_artist_details) {
    private val args: ArtistDetailsFragmentArgs by navArgs()
    private val binding by viewBinding(FragmentArtistDetailsBinding::bind)


    @SuppressLint("SetTextI18n")
    override fun setupView() {
        binding.apply {
            nameTv.text = "name: ${args.name}"
            disambiguationTv.text = "disambiguation: ${args.disambiguation}"
            typeTv.text = "type: ${args.type}"
            countryTv.text = "country: ${args.country}"
            ratingTv.text = "rating: ${args.rating}"
            voteCountTv.text = "votes: ${args.votes}"
        }
    }
}