package com.example.retrofit.presentation.search.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.copy_challenge.R
import com.example.copy_challenge.databinding.ActivitySearchBinding
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SearchActivity : AppCompatActivity() {
    private val binding: ActivitySearchBinding by lazy {
        ActivitySearchBinding.inflate(layoutInflater)
    }
    private val viewPagerAdapter:SearchViewPagerAdapter by lazy {
        SearchViewPagerAdapter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

//        setFragment(SearchFragment())

//        binding.tlTop.addTab(binding.tlTop.newTab().setText("Search"))
//        binding.tlTop.addTab(binding.tlTop.newTab().setText("BookMark"))
//
//        binding.tlTop.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
//            override fun onTabSelected(tab: TabLayout.Tab) {
//                val fragment = when (tab.position) {
//                    0 -> SearchFragment()
//                    1 -> BookMarkFragment()
//                    else -> throw IllegalStateException("Unexpected position ${tab.position}")
//                }
//                setFragment(fragment)
//            }
//
//            override fun onTabUnselected(p0: TabLayout.Tab?) {
//
//            }
//
//            override fun onTabReselected(p0: TabLayout.Tab?) {
//
//            }
//
//        })

        initView()
    }

    private fun initView() = with(binding){
        vp.adapter = viewPagerAdapter
        vp.offscreenPageLimit= viewPagerAdapter.itemCount

        TabLayoutMediator(tlTop, vp){tab, position ->
            tab.setText(viewPagerAdapter.getTitle(position))
        }.attach()
    }

//    private fun setFragment(fragment: Fragment) {
//        this@SearchActivity.supportFragmentManager.beginTransaction()
//            .replace(R.id.frameLayout, fragment)
//            .addToBackStack(null)
//            .commit()
//    }
}




