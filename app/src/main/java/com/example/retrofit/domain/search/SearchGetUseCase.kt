package com.example.retrofit.domain.search

import com.example.retrofit.domain.search.model.SearchImageEntity
import com.example.retrofit.domain.search.model.SearchVideoEntity

class SearchGetUseCase(
    private val repository: SearchRepository
) {
    suspend fun imageGet(
        query: String,
        sort: String = "accuracy",
        page: Int = 1,
        size :Int = 80
    ): SearchImageEntity = repository.getSearchImage(
        query,
        sort,
        page,
        size
    )
    suspend fun videoGet(
        query: String,
        sort: String = "accuracy",
        page: Int = 1,
        size :Int = 30
    ): SearchVideoEntity = repository.getSearchVideo(
        query,
        sort,
        page,
        size
    )
}