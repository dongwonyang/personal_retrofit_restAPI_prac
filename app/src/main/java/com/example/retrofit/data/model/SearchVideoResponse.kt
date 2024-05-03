package com.example.retrofit.data.model

import com.google.gson.annotations.SerializedName
import java.util.Date

data class SearchVideoResponse (
    @SerializedName("meta") val meta: MetaResponse,
    @SerializedName("documents") val documents: List<VideoDocumentResponse>

)

data class VideoDocumentResponse(
    @SerializedName("title") val title: String,
    @SerializedName("url") val url: String,
    @SerializedName("datetime") val datetime: Date,
    @SerializedName("play_time") val playTime: Int,
    @SerializedName("thumbnail") val thumbnail: String,
    @SerializedName("author") val author: String
)