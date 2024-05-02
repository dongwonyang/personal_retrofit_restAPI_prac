package com.example.retrofit.presentation.search.bookmark

data class BookmarkListUiState(
    val list: List<BookmarkListItem>,
    val isLoading: Boolean
) {
    companion object{
        fun init() = BookmarkListUiState(
            list = emptyList(),
            isLoading = false
        )
    }
}