package com.dentag.myreddit.ui.list

import androidx.recyclerview.widget.RecyclerView
import com.dentag.myreddit.data.Post
import com.dentag.myreddit.databinding.ItemPostBinding

class PostViewHolder(
    private val binding: ItemPostBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(post: Post?) {
        post?.let {
            with(binding) {
                authorName.text = post.authorFullName
                title.text = post.title
                upvoteRatio.text = post.upvoteRatio.toString()
                numComments.text = post.numComments.toString()
            }
        }
    }
}