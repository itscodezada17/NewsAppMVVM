package com.example.newsappmvvm.ui.viewmodel

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsappmvvm.data.models.News
import com.example.newsappmvvm.data.repos.NewsRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NewsViewModel: ViewModel() {
    val news= MutableLiveData<List<News>>()
    fun fetchNews(){
        viewModelScope.launch{
            val response = withContext(Dispatchers.IO){NewsRepo.getNews()}

            if(response.isSuccessful){
                response.body()?.let {

                    it.articles?.let{newsItem->
                        news.postValue(newsItem)
                    }
                }
            }
            else{
                //Toast.makeText(this,"Response Failed",Toast.LENGTH_LONG).show()
            }
        }
    }
}