package com.example.newsappmvvm.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.newsappmvvm.data.models.News
import com.example.newsappmvvm.databinding.ItemNews1stBinding
import com.example.newsappmvvm.databinding.ItemNewsBinding
import com.squareup.picasso.Picasso

open class MainRecyclerViewHolder(binding:ViewBinding) : RecyclerView.ViewHolder(binding.root) {

   class newsViewHolder(private val binding: ItemNewsBinding):MainRecyclerViewHolder(binding){
       fun bind(news: News){
           binding.thumbnail.text=news.title
           binding.publishTime.text=news.publishedAt
           Picasso.get().load(news.urlToImage).into(binding.img)
       }
   }


    class newsViewHolder1st(private val binding: ItemNews1stBinding):MainRecyclerViewHolder(binding){
        fun bind(news: News){
            binding.thumbnail1st.text=news.title
            binding.publishTime1st.text=news.publishedAt
            Picasso.get().load(news.urlToImage).into(binding.iv1st)

        }
    }
}