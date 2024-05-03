package com.example.retrofit.data.repository

import com.example.retrofit.data.remote.SearchRemoteDatasource
import com.example.retrofit.domain.search.model.toEntity
import com.example.retrofit.domain.search.SearchRepository

class SearchRepositoryImpl(
    private val remoteDatasource: SearchRemoteDatasource
) : SearchRepository {
    override suspend fun getSearchImage(
        query: String,
        sort: String,
        page: Int,
        size: Int
    ) = remoteDatasource.getSearchImage(
        query,
        sort,
        page,
        size
    ).toEntity()

    override suspend fun getSearchVideo(
        query: String,
        sort: String,
        page: Int,
        size: Int
    ) =remoteDatasource.getSearchVideo(
        query,
        sort,
        page,
        size
    ).toEntity()
}