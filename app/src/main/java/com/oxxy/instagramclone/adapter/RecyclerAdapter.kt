package com.oxxy.instagramclone.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.oxxy.instagramclone.databinding.RecyclerRowBinding
import com.oxxy.instagramclone.model.Post
import com.squareup.picasso.Picasso

class RecyclerAdapter(val postList: ArrayList<Post>): RecyclerView.Adapter<RecyclerAdapter.PostHolder>() {
    class PostHolder(val binding: RecyclerRowBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostHolder(binding)
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: PostHolder, position: Int) {
        holder.binding.recyclerEmail.text = postList.get(position).email
        holder.binding.recyclerComment.text = postList.get(position).comment
        Picasso.get().load(postList.get(position).downloadUrl).into(holder.binding.recyclerImage)

    }
}