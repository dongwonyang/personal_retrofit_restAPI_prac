package com.example.retrofit.presentation.search.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.copy_challenge.databinding.FragmentSearchBinding
import com.example.retrofit.presentation.search.shared.SearchSharedViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


class SearchFragment : Fragment() {
    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding ?: error("Binding is not initialized")

    private val viewModel: SearchViewModel by viewModels{
        SearchViewModelFactory()
    }
    private val adapter: SearchListAdapter by lazy{
        SearchListAdapter(
            onClick = {

            },
            onBookmark = { item->
                viewModel.onBookmark(item)
            }
        )
    }

    private val sharedViewModel:SearchSharedViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initViewModel()

        viewModel.onSearch("kotlin")
    }

    private fun initView() = with(binding){
        rvSearch.adapter = adapter
        rvSearch.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun initViewModel() = with(viewModel){
        // collect : 새로운 데이터가 발행 되면 끝날 때 까지 기다림
        // collectLatest : 새로운 데이터가 발행되면 이전 처리르 취소하고 새로운 데이터 처리
        viewLifecycleOwner.lifecycleScope.launch {
            uiState.flowWithLifecycle(lifecycle)
                .collectLatest { state ->
                    onBind(state)
                }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            event.flowWithLifecycle(viewLifecycleOwner.lifecycle)
                .collectLatest { event->
                    onEvent(event)
                }
        }
    }

    private fun onBind(
        state: SearchListUiState
    ) = with(binding){
        adapter.submitList(state.list)
        progress.isVisible = state.isLoading
    }

    private fun onEvent(
        event: SearchListEvent
    ){
        when(event){
            is SearchListEvent.UpdateBookmark -> sharedViewModel.updateBookmarkItems(event.list)
        }
    }
    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    companion object {
        fun newInstance() = SearchFragment()

    }
}