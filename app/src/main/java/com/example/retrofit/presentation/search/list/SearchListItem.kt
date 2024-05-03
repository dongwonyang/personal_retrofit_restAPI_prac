package com.example.retrofit.presentation.search.list

import java.util.Date

sealed interface SearchListItem {
    val date: Date?
    val id: String
    val bookmarked: Boolean
    val thumbnail: String?
    val title: String?
    val url: String?
    data class ImageItem(
        override val id: String,
        override val title:String?,
        override val thumbnail: String?,
        override val date: Date?,
        override val bookmarked: Boolean = false,
        override val url: String?,
    ): SearchListItem

    data class VideoItem(
        override val date: Date?,
        override val id: String,
        override val bookmarked: Boolean = false,
        override val thumbnail: String?,
        override val title: String?,
        override val url: String?,
    ): SearchListItem
}