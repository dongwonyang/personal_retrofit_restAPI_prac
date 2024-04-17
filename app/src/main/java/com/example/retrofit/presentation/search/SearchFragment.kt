package com.example.retrofit.presentation.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.copy_challenge.R
import com.example.copy_challenge.databinding.FragmentSearchBinding
import com.example.retrofit.data.repository.SearchRepositoryImpl
import com.example.retrofit.presentation.search.model.ImageDocumentEntity
import com.example.retrofit.presentation.search.model.SearchImageEntity
import com.example.retrofit.presentation.search.repository.SearchRepository
import com.example.retrofit.presentation.search.repository.SearchViewModel
import com.example.retrofit.presentation.search.repository.SearchViewModelFactory

private const val ARG_PARAM1 = "param1"

class SearchFragment : Fragment() {
    private var param1: String? = null
    private lateinit var binding:FragmentSearchBinding
    private val viewModel: SearchViewModel by viewModels {
        SearchViewModelFactory()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel.onSearch(param1 ?: "")
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        binding.rvSearch.layoutManager = LinearLayoutManager(binding.root.context)

        viewModel.getResponse().observe(viewLifecycleOwner, Observer { response ->
            val documents = response?.documents
            if (!documents.isNullOrEmpty()) {
                binding.rvSearch.adapter = SearchRecyclerAdapter(documents)
            } else {
                binding.rvSearch.adapter = SearchRecyclerAdapter(emptyList())
            }
        })

        return binding.root
    }

    companion object {
        fun newInstance(param1: String) =
            SearchFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }
}