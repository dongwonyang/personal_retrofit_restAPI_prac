package com.example.retrofit.domain.search.model

import com.example.retrofit.data.model.MetaResponse
import com.example.retrofit.data.model.VideoDocumentResponse
import com.google.gson.annotations.SerializedName
import java.util.Date

data class SearchImageEntity(
    val meta: MetaEntity?,
    val documents: List<ImageDocumentEntity>?,
)

data class SearchVideoEntity (
    val meta: MetaEntity?,
    val documents: List<VideoDocumentEntity>?
)

data class MetaEntity(
    val totalCount: Int?,
    val pageableCount: Int?,
    val isEnd: Boolean?,
)

data class ImageDocumentEntity(
    val id: String,
    val collection: String?,
    val thumbnailUrl: String?,
    val imageUrl: String?,
    val width: Int?,
    val height: Int?,
    val displaySitename: String?,
    val docUrl: String?,
    val datetime: Date?,
)

data class VideoDocumentEntity(
    val id: String,
    val title: String,
    val playTime: Int,
    val thumbnail: String,
    val url: String,
    val datetime: Date,
    val author: String
)