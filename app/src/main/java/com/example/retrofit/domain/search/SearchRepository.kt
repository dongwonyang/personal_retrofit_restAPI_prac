package com.example.retrofit.domain.search

import com.example.retrofit.domain.search.model.SearchImageEntity
import com.example.retrofit.domain.search.model.SearchVideoEntity
import retrofit2.http.GET

interface SearchRepository {
    suspend fun getSearchImage(
        query: String,
        sort: String = "accuracy",
        page: Int = 1,
        size: Int = 80
    ): SearchImageEntity

    suspend fun getSearchVideo(
        query: String,
        sort: String = "accuracy",
        page: Int = 1,
        size: Int = 30
    ): SearchVideoEntity
}