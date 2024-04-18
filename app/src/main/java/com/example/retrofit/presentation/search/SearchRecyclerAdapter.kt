package com.example.retrofit.presentation.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.copy_challenge.databinding.ItemSearchBinding
import com.example.retrofit.data.BookMarkData
import com.example.retrofit.presentation.search.model.ImageDocumentEntity

class SearchRecyclerAdapter(
    private val itemList: List<ImageDocumentEntity>
) : RecyclerView.Adapter<SearchRecyclerAdapter.ViewHolder>(){
    private lateinit var binding:ItemSearchBinding
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SearchRecyclerAdapter.ViewHolder {
        val binding = ItemSearchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchRecyclerAdapter.ViewHolder, position: Int) {
        val item = itemList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class ViewHolder(private val binding: ItemSearchBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ImageDocumentEntity){
            with(binding){
                Glide.with(binding.root)
                    .load(item.imageUrl)
                    .into(ivSearchImage)

                tvSearchTitle.text = item.displaySitename

                if(BookMarkData.bookmarkList.contains(item)){
                    binding.switch1.isChecked = true
                }

                binding.switch1.setOnCheckedChangeListener { buttonView, isChecked ->
                    if (isChecked) {
                        BookMarkData.bookmarkList.add(item)
                    } else {
                        BookMarkData.bookmarkList.remove(item)
                    }
                }
            }
        }
    }
}