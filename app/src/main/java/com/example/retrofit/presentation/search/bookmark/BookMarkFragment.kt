package com.example.retrofit.presentation.search.bookmark

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.example.copy_challenge.databinding.FragmentBookmarkBinding
import com.example.retrofit.presentation.search.shared.SearchSharedEvent
import com.example.retrofit.presentation.search.shared.SearchSharedViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

private const val ARG_PARAM1 = "param1"

class BookMarkFragment : Fragment(){
    private var param1: String? = null
    private var _binding: FragmentBookmarkBinding? = null
    private val binding get()=_binding!!

    private val viewModel : BookmarkViewModel by viewModels()

    private val sharedViewModel: SearchSharedViewModel by lazy{
        ViewModelProvider(requireActivity())[SearchSharedViewModel::class.java]
    }

    private val adapter: BookmarkListAdapter by lazy{
        BookmarkListAdapter {
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments.let{
            param1 = it?.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBookmarkBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initViewModel()
    }

    private fun initView() = with(binding){
        rvBookmark.adapter = adapter
    }

    private fun initViewModel(){
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.uiState.flowWithLifecycle(viewLifecycleOwner.lifecycle)
                .collectLatest { state ->
                    onBind(state)
                }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            sharedViewModel.event.flowWithLifecycle(viewLifecycleOwner.lifecycle)
                .collectLatest { event->
                    onSharedEvent(event)
                }
        }
    }


    private fun onBind(
        state: BookmarkListUiState
    ) = with(binding){
        adapter.submitList(state.list)
    }


    private fun onSharedEvent(
        event: SearchSharedEvent
    ){
        when(event){
             is SearchSharedEvent.UpdateBookmark -> viewModel.updateBookmark(event.list)
        }
    }


    companion object{
        fun newInstance() = BookMarkFragment()
    }
}