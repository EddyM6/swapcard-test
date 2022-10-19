package com.example.musicalartistsapplication.common.presentation.mapper


import com.example.musicalartistsapplication.common.domain.model.ArtistsListDomainModel
import com.example.musicalartistsapplication.common.presentation.model.ArtistsListUiModel
import com.example.musicalartistsapplication.core.mapper.Mapper

class ArtistsListDomainToUiMapper : Mapper<ArtistsListDomainModel, ArtistsListUiModel> {

    override fun map(inputModel: ArtistsListDomainModel): ArtistsListUiModel =
        ArtistsListUiModel(
            nodes = inputModel.nodes?.map { it?.map() },
            pageInfo = inputModel.pageInfo?.map()
        )

    private fun ArtistsListDomainModel.Node.map(): ArtistsListUiModel.Node =
        ArtistsListUiModel.Node(
            country = this.country,
            disambiguation = this.disambiguation,
            id = this.id,
            name = this.name,
            rating = this.rating?.map(),
            type = this.type
        )

    private fun ArtistsListDomainModel.Node.Rating.map(): ArtistsListUiModel.Node.Rating =
        ArtistsListUiModel.Node.Rating(
            value = this.value,
            voteCount = this.voteCount
        )

    private fun ArtistsListDomainModel.PageInfo.map(): ArtistsListUiModel.PageInfo =
        ArtistsListUiModel.PageInfo(
            endCursor = this.endCursor,
            hasNextPage = this.hasNextPage,
            hasPreviousPage = this.hasPreviousPage,
            startCursor = this.endCursor
        )
}