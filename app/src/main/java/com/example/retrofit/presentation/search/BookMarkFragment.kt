package com.example.retrofit.presentation.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.copy_challenge.databinding.FragmentBookmarkBinding
import com.example.retrofit.data.BookMarkData

private const val ARG_PARAM1 = "param1"
class BookMarkFragment : Fragment(){
    private var param1: String? = null
    private lateinit var binding: FragmentBookmarkBinding
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
        binding = FragmentBookmarkBinding.inflate(inflater, container, false)

        binding.rvBookmark.adapter = SearchRecyclerAdapter(BookMarkData.bookmarkList.toList())
        binding.rvBookmark.layoutManager = LinearLayoutManager(binding.root.context)
        return binding.root
    }


    companion object{
        fun newInstance(param: String):BookMarkFragment =
            BookMarkFragment().apply {
                arguments= Bundle().apply {
                    Bundle().putString(ARG_PARAM1, param)
                }
            }
    }
}