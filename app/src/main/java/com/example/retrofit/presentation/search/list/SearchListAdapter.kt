package com.example.retrofit.presentation.search.list

import android.graphics.Bitmap
import android.graphics.Color
import android.media.ThumbnailUtils
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.copy_challenge.databinding.ItemSearchBinding
import com.example.copy_challenge.databinding.ItemUnknownBinding

class SearchListAdapter(
    private val onClick:(SearchListItem) -> Unit,
    private val onBookmark:(SearchListItem) -> Unit
)
    : ListAdapter<SearchListItem, SearchListAdapter.ViewHolder>(
    object : DiffUtil.ItemCallback<SearchListItem>() {
        override fun areItemsTheSame(
            oldItem: SearchListItem,
            newItem: SearchListItem
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: SearchListItem,
            newItem: SearchListItem
        ): Boolean {
            return oldItem == newItem
        }

    }
) {

    enum class SearchItemViewType{
        IMAGE, VIDEO
    }

    abstract class ViewHolder(
        root: View
    ):RecyclerView.ViewHolder(root){
        abstract fun onBind(item: SearchListItem)
    }

    override fun getItemViewType(position: Int): Int  = when(getItem(position)){
        is SearchListItem.ImageItem -> SearchItemViewType.IMAGE.ordinal
        is SearchListItem.VideoItem -> SearchItemViewType.VIDEO.ordinal
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        when(viewType){
            SearchItemViewType.IMAGE.ordinal ->
                ImageViewHolder(
                    ItemSearchBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    ),
                    onClick,
                    onBookmark
                )

            SearchItemViewType.VIDEO.ordinal->
                VideoViewHolder(
                    ItemSearchBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    ),
                    onClick,
                    onBookmark
                )

            else -> UnknownViewHolder(
                ItemUnknownBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    class ImageViewHolder(
        private val binding: ItemSearchBinding,
        private val onClick: (SearchListItem) -> Unit,
        private val onBookmark: (SearchListItem) -> Unit
    ): ViewHolder(binding.root) {
        override fun onBind(item: SearchListItem)= with(binding) {
            if(item is SearchListItem.ImageItem) {
                tvSearchTitle.text = item.title
                ivSearchImage.load(item.thumbnail)
                switch1.isChecked = item.bookmarked
                container.setOnClickListener {
                    onClick(item)
                }

                switch1.setOnClickListener {
                    if (item.bookmarked != switch1.isChecked) {
                        onBookmark(item)
                    }
                }
            }
        }
    }

    class VideoViewHolder(
        private val binding: ItemSearchBinding,
        private val onClick: (SearchListItem) -> Unit,
        private val onBookmark: (SearchListItem) -> Unit
    ): ViewHolder(binding.root) {
        override fun onBind(item: SearchListItem) = with(binding){
            tvSearchTitle.text = item.title
            ivSearchImage.load(item.thumbnail)
            switch1.isChecked = item.bookmarked
            container.setBackgroundColor(Color.GRAY)

            container.setOnClickListener {
                onClick(item)
            }

            switch1.setOnClickListener {
                if (item.bookmarked != switch1.isChecked) {
                    onBookmark(item)
                }
            }
        }

    }

    class UnknownViewHolder(
        binding: ItemUnknownBinding
    ) : ViewHolder(binding.root) {
        override fun onBind(item: SearchListItem) = Unit
    }
}