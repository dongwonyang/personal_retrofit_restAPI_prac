package com.example.retrofit.presentation.search.shared

import com.example.retrofit.presentation.search.bookmark.BookmarkListItem

sealed interface SearchSharedEvent {
    data class UpdateBookmark(
        val list: List<BookmarkListItem>
    ): SearchSharedEvent
}