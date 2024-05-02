package com.example.retrofit.data.remote

import com.example.retrofit.data.model.SearchImageResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchRemoteDatasource {
    @GET("/v2/search/image")
    suspend fun getSearchImage(
        @Query("query") query: String,
        @Query("sort") sort: String,
        @Query("page") page: Int,
        @Query("size") size: Int
    ): SearchImageResponse
}