package com.example.musicalartistsapplication.common.domain.model

data class ArtistsListDomainModel(
    val nodes: List<Node?>?,
    val pageInfo: PageInfo?
) {
    data class Node(
        val country: String?,
        val disambiguation: String?,
        val id: String?,
        val name: String?,
        val rating: Rating?,
        val type: String?
    ) {
        data class Rating(
            val value: Double?,
            val voteCount: Int?
        )
    }

    data class PageInfo(
        val endCursor: String?,
        val hasNextPage: Boolean?,
        val hasPreviousPage: Boolean?,
        val startCursor: String?
    )
}