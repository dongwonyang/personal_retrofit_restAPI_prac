package com.example.retrofit.presentation.search

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.copy_challenge.R
import com.example.copy_challenge.databinding.ActivitySearchBinding
import com.example.retrofit.data.BookMarkData
import com.example.retrofit.presentation.search.repository.SearchViewModel
import com.example.retrofit.presentation.search.repository.SearchViewModelFactory
import com.google.android.material.tabs.TabLayout


class SearchActivity : AppCompatActivity() {
    private val binding: ActivitySearchBinding by lazy {
        ActivitySearchBinding.inflate(layoutInflater)
    }
    private val viewModel: SearchViewModel by viewModels {
        SearchViewModelFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


//        val bookmarkFragment = BookmarkFragment()

        setFragment(SearchFragment.newInstance("kotlin"))

        binding.tlTop.addTab(binding.tlTop.newTab().setText("Search"))
        binding.tlTop.addTab(binding.tlTop.newTab().setText("BookMark"))

        binding.tlTop.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                val fragment = when (tab.position) {
                    0 -> SearchFragment.newInstance("kotlin")
                    1 -> BookMarkFragment()
                    else -> throw IllegalStateException("Unexpected position ${tab.position}")
                }
                setFragment(fragment)
            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {

            }

            override fun onTabReselected(p0: TabLayout.Tab?) {

            }

        })
    }

    private fun setFragment(fragment: Fragment) {
        this@SearchActivity.supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayout, fragment)
            .addToBackStack(null)
            .commit()
    }
}




