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
import java.text.SimpleDateFormat
import java.util.*

class NewsViewModel: ViewModel() {
    val news= MutableLiveData<List<News>>()
    fun fetchNews(){
        viewModelScope.launch{
            val response = withContext(Dispatchers.IO){NewsRepo.getNews()}
            if(response.isSuccessful){
                response.body()?.let {
                    it.articles?.let{
                            newsItem->
                        news.postValue(newsItem)
                    }
                }
            }
            else{
                //Toast.makeText(this,"Response Failed",Toast.LENGTH_LONG).show()
            }
        }
    }

    fun convertUtcToIst(utcDateTime: String): String {
        val utcFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        utcFormat.timeZone = TimeZone.getTimeZone("UTC")
        val utcDate = utcFormat.parse(utcDateTime)

        val istFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        istFormat.timeZone = TimeZone.getTimeZone("Asia/Kolkata")
        val istDateTime = istFormat.format(utcDate)

        return istDateTime
    }
}