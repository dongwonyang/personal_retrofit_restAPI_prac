package com.example.retrofit.presentation.search

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.copy_challenge.R
import com.example.copy_challenge.databinding.ActivitySearchBinding
import com.example.retrofit.presentation.search.repository.SearchViewModel
import com.example.retrofit.presentation.search.repository.SearchViewModelFactory


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
    }
    private fun setFragment(fragment: Fragment){
        this@SearchActivity.supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayout, fragment)
            .addToBackStack(null)
            .commit()
    }
}


