package com.example.retrofit.domain.search.model

import com.example.retrofit.data.model.ImageDocumentResponse
import com.example.retrofit.data.model.MetaResponse
import com.example.retrofit.data.model.SearchImageResponse
import com.example.retrofit.data.model.SearchVideoResponse
import com.example.retrofit.data.model.VideoDocumentResponse
import java.util.Date
import java.util.UUID

fun SearchImageResponse.toEntity() = SearchImageEntity(
    meta = meta?.toEntity(),
    documents = documents?.map {
        it.toEntity()
    }
)

fun SearchVideoResponse.toEntity() = SearchVideoEntity(
    meta = meta?.toEntity(),
    documents = documents?.map {
        it.toEntity()
    }
)

fun MetaResponse.toEntity() = MetaEntity(
    totalCount = totalCount,
    pageableCount = pageableCount,
    isEnd = isEnd,
)

fun ImageDocumentResponse.toEntity() = ImageDocumentEntity(
    id = UUID.randomUUID().toString(),
    collection = collection,
    thumbnailUrl = thumbnailUrl,
    imageUrl = imageUrl,
    width = width,
    height = height,
    displaySitename = displaySitename,
    docUrl = docUrl,
    datetime = datetime,
)

fun VideoDocumentResponse.toEntity() = VideoDocumentEntity(
    id = UUID.randomUUID().toString(),
    title = title,
    playTime = playTime,
    thumbnail = thumbnail,
    url = url,
    datetime = datetime,
    author = author
)