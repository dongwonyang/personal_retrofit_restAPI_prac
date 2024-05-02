package com.example.retrofit.presentation.search.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.copy_challenge.R
import com.example.retrofit.presentation.search.bookmark.BookMarkFragment
import com.example.retrofit.presentation.search.list.SearchFragment

class SearchViewPagerAdapter(
    fragmentActivity: FragmentActivity
) : FragmentStateAdapter(fragmentActivity){

    private val fragments = listOf(
        SearchMainTapModel(SearchFragment.newInstance(), R.string.search_tab),
        SearchMainTapModel(BookMarkFragment.newInstance(), R.string.bookmark_tab)
    )

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position].fragment
    }

    fun getTitle(position: Int): Int = fragments[position].title
}