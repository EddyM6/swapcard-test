package com.example.musicalartistsapplication.common.data.mapper

import com.example.musicalartistsapplication.common.data.model.ArtistsListDataModel
import com.example.musicalartistsapplication.common.domain.model.ArtistsListDomainModel
import com.example.musicalartistsapplication.core.mapper.Mapper

class ArtistsListDataToDomainMapper :
    Mapper<ArtistsListDataModel, ArtistsListDomainModel> {

    override fun map(inputModel: ArtistsListDataModel): ArtistsListDomainModel =
        ArtistsListDomainModel(
            nodes = inputModel.nodes?.map { it?.map() },
            pageInfo = inputModel.pageInfo?.map()
        )

    private fun ArtistsListDataModel.Node.map(): ArtistsListDomainModel.Node =
        ArtistsListDomainModel.Node(
            country = this.country,
            disambiguation = this.disambiguation,
            id = this.id,
            name = this.name,
            rating = this.rating?.map(),
            type = this.type
        )

    private fun ArtistsListDataModel.Node.Rating.map(): ArtistsListDomainModel.Node.Rating =
        ArtistsListDomainModel.Node.Rating(
            value = this.value,
            voteCount = this.voteCount
        )

    private fun ArtistsListDataModel.PageInfo.map(): ArtistsListDomainModel.PageInfo =
        ArtistsListDomainModel.PageInfo(
            endCursor = this.endCursor,
            hasNextPage = this.hasNextPage,
            hasPreviousPage = this.hasPreviousPage,
            startCursor = this.endCursor
        )
}