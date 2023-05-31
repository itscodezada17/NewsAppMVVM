package com.example.newsappmvvm.ui.view

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsappmvvm.R
import com.example.newsappmvvm.data.models.News
import com.example.newsappmvvm.data.repos.NewsRepo
import com.example.newsappmvvm.databinding.ActivityMainBinding
import com.example.newsappmvvm.databinding.ItemNewsBinding
import com.example.newsappmvvm.ui.adapter.NewsAdapter
import com.example.newsappmvvm.ui.viewmodel.NewsViewModel
import java.util.function.Consumer

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val vm by lazy {
        ViewModelProvider(this).get(NewsViewModel::class.java)
    }
    val list= arrayListOf<News>()
    val adapter = NewsAdapter(list)

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.newsRv.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = this@MainActivity.adapter
        }

        vm.fetchNews()

        vm.news.observe(this, Observer {
            if(!it.isNullOrEmpty()){
                list.addAll(it)
                adapter.notifyDataSetChanged()
            }
            else{

            }

        })
    }
}