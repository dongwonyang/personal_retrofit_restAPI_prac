package com.example.retrofit.presentation.search.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.retrofit.data.repository.SearchRepositoryImpl
import com.example.retrofit.network.RetrofitClient
import com.example.retrofit.presentation.search.model.SearchImageEntity
import kotlinx.coroutines.launch

class SearchViewModel(
    private val searchRepository: SearchRepository
) : ViewModel() {
    private val response = MutableLiveData<SearchImageEntity>()
    fun onSearch(query: String) = viewModelScope.launch{
        runCatching {
            response.value = searchRepository.getSearchImage(query)
            Log.d("jess", response.value.toString())
        }.onFailure {
            if (it.message == "인증만료") {
                // 갱신 - ui 처리
            }
        }
    }
    fun getResponse() = response
}

class SearchViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(
        modelClass: Class<T>,
        extras: CreationExtras
    ): T {
        return SearchViewModel(
            SearchRepositoryImpl(RetrofitClient.search)
        ) as T
    }
}