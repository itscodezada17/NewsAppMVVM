package com.example.newsappmvvm.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.newsappmvvm.R
import com.example.newsappmvvm.data.models.News
import com.example.newsappmvvm.data.models.NewsBase
import com.example.newsappmvvm.databinding.ItemNews1stBinding
import com.example.newsappmvvm.databinding.ItemNewsBinding
import com.squareup.picasso.Picasso

class NewsAdapter(private val newsList:List<News>) : RecyclerView.Adapter<MainRecyclerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainRecyclerViewHolder {
        return when (viewType) {
            R.layout.item_news1st -> MainRecyclerViewHolder.newsViewHolder1st(
                ItemNews1stBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

            R.layout.item_news -> MainRecyclerViewHolder.newsViewHolder(
                ItemNewsBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            else -> throw IllegalArgumentException("viewType Not found")
        }
    }

    override fun getItemCount()=newsList.size


    override fun onBindViewHolder(holder: MainRecyclerViewHolder, position: Int) {
        when(holder){
            is MainRecyclerViewHolder.newsViewHolder -> holder.bind(newsList[position])
            is MainRecyclerViewHolder.newsViewHolder1st -> holder.bind(newsList[position])
            else -> {}
        }
    }

    override fun getItemViewType(position: Int): Int {
             if(position==0) return R.layout.item_news1st
        else return R.layout.item_news
    }

}


// override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):MainRecyclerViewHolder {
// }
//
// override fun getItemCount() = newsList.size
//
//  override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
// with(holder){
// with(newsList[position]){
// binding.thumbnail.text = newsList[position].title
// binding.publishTime.text=newsList[position].publishedAt
// Picasso.get().load(newsList[position].urlToImage).into(binding.img)
// }
//
// }
// }