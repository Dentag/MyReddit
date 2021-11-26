package com.dentag.myreddit.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.dentag.myreddit.data.Post
import com.dentag.myreddit.databinding.ItemPostBinding

class PostAdapter : PagingDataAdapter<Post, PostViewHolder>(differ) {

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemPostBinding.inflate(layoutInflater, parent, false)
        return PostViewHolder(binding)
    }

    companion object {
        private val differ = object : DiffUtil.ItemCallback<Post>() {
            override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
                return oldItem == newItem
            }
        }
    }
}