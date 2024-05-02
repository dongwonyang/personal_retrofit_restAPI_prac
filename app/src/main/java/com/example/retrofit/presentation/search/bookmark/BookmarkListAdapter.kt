package com.example.retrofit.presentation.search.bookmark

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.copy_challenge.databinding.FragmentBookmarkBinding
import com.example.copy_challenge.databinding.ItemSearchBinding

class BookmarkListAdapter(
  private val onBookmark:(BookmarkListItem) -> Unit
) :ListAdapter<BookmarkListItem, BookmarkListAdapter.ViewHolder>(
        object :DiffUtil.ItemCallback<BookmarkListItem>(){
            override fun areItemsTheSame(
                oldItem: BookmarkListItem,
                newItem: BookmarkListItem
            ): Boolean {
                return oldItem.title == newItem.title
            }

            override fun areContentsTheSame(
                oldItem: BookmarkListItem,
                newItem: BookmarkListItem
            ): Boolean {
                return oldItem == newItem
            }
        }
    ){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BookmarkListAdapter.ViewHolder =
        BookmarkViewHolder(
            ItemSearchBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: BookmarkListAdapter.ViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    abstract class ViewHolder(
        root: View
    ): RecyclerView.ViewHolder(root){
        abstract fun onBind(item:BookmarkListItem)
    }

    class BookmarkViewHolder(
        private val binding: ItemSearchBinding
    ):ViewHolder(binding.root){
        override fun onBind(item: BookmarkListItem)=with(binding) {
            tvSearchTitle.text = item.title
            ivSearchImage.load(item.thumbnail)
            switch1.isChecked= item.bookmarked
        }

    }
}