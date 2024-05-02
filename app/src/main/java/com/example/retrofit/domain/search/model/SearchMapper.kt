package com.example.retrofit.domain.search.model

import com.example.retrofit.data.model.ImageDocumentResponse
import com.example.retrofit.data.model.MetaResponse
import com.example.retrofit.data.model.SearchImageResponse
import java.util.UUID

fun SearchImageResponse.toEntity() = SearchImageEntity(
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