package com.example.retrofit.domain.search

import com.example.retrofit.domain.search.model.SearchImageEntity

class SearchGetImageUseCase(
    private val repository: SearchRepository
) {
    suspend operator fun invoke(
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
}