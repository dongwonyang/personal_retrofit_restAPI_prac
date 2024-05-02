package com.example.retrofit.presentation.search.list

import java.util.Date

sealed interface SearchListItem {
    val date: Date?
    val id: String
    val bookmarked: Boolean
    val thumbnail: String?
    val title: String?
    data class ImageItem(
        override val id: String,
        override val title:String?,
        override val thumbnail: String?,
        override val date: Date?,
        override val bookmarked: Boolean = false,
    ): SearchListItem
}