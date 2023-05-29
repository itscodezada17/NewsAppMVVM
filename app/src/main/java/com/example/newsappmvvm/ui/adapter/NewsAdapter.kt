package com.example.newsappmvvm.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.newsappmvvm.data.models.News
import com.example.newsappmvvm.databinding.ItemNewsBinding
import com.squareup.picasso.Picasso

class NewsAdapter(private val newsList:List<News>) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    inner class NewsViewHolder(val binding: ItemNewsBinding):RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding = ItemNewsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        with(holder){
            with(newsList[position]){
                binding.thumbnail.text = newsList[position].title
                binding.publishTime.text=newsList[position].publishedAt
                Picasso.get().load(newsList[position].urlToImage).into(binding.img)
            }

        }
    }

    override fun getItemCount() = newsList.size

}




