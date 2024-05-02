package com.example.retrofit.presentation.search.bookmark

data class BookmarkListItem (
    val id: String,
    val title: String?,
    val bookmarked: Boolean,
    val thumbnail: String?
)