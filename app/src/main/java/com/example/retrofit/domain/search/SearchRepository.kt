package com.example.retrofit.domain.search

import com.example.retrofit.domain.search.model.SearchImageEntity

interface SearchRepository {
    suspend fun getSearchImage(
        query: String,
        sort: String = "accuracy",
        page: Int = 1,
        size: Int = 80
    ): SearchImageEntity
}