package com.example.musicalartistsapplication.common.data.mapper

import com.apollographql.apollo3.api.ApolloResponse
import com.example.musicalartistsapp.GetSearchResultQuery
import com.example.musicalartistsapplication.common.data.model.ArtistsListDataModel
import com.example.musicalartistsapplication.core.mapper.Mapper

class ArtistsListResponseToDataMapper :
    Mapper<ApolloResponse<GetSearchResultQuery.Data>, ArtistsListDataModel> {

    override fun map(inputModel: ApolloResponse<GetSearchResultQuery.Data>): ArtistsListDataModel =
        ArtistsListDataModel(
            nodes = inputModel.data?.search?.artists?.nodes?.map { it?.map() },
            pageInfo = inputModel.data?.search?.artists?.pageInfo?.map()
        )

    private fun GetSearchResultQuery.Node.map(): ArtistsListDataModel.Node =
        ArtistsListDataModel.Node(
            country = this.country,
            disambiguation = this.disambiguation,
            id = this.id,
            name = this.name,
            rating = this.rating?.map(),
            type = this.type
        )

    private fun GetSearchResultQuery.Rating.map(): ArtistsListDataModel.Node.Rating =
        ArtistsListDataModel.Node.Rating(
            value = this.value,
            voteCount = this.voteCount
        )

    private fun GetSearchResultQuery.PageInfo.map(): ArtistsListDataModel.PageInfo =
        ArtistsListDataModel.PageInfo(
            endCursor = this.endCursor,
            hasNextPage = this.hasNextPage,
            hasPreviousPage = this.hasPreviousPage,
            startCursor = this.endCursor
        )
}


