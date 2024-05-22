package com.example.retrofit.presentation.search.di

import com.example.retrofit.data.repository.SearchRepositoryImpl
import com.example.retrofit.domain.search.SearchRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@InstallIn(ViewModelComponent::class)
@Module
abstract class SearchViewModelBindModule{

    @ViewModelScoped
    @Binds
    abstract fun bindSearchRepository(
        repository: SearchRepositoryImpl
    ): SearchRepository
}