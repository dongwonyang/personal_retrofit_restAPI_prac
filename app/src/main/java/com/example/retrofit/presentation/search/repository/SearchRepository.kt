package com.example.retrofit.presentation.search.repository

import com.example.retrofit.presentation.search.model.SearchImageEntity

interface SearchRepository {
    suspend fun getSearchImage(
        query: String,
        sort: String = "accuracy",
        page: Int = 1,
        size: Int = 80
    ): SearchImageEntity
}