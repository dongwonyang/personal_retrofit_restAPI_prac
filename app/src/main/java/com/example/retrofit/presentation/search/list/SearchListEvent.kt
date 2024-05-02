package com.example.retrofit.presentation.search.list

sealed interface SearchListEvent {

    data class UpdateBookmark(
        val list: List<SearchListItem>
    ) : SearchListEvent
}