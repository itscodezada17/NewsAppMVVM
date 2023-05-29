package com.example.newsappmvvm.data.repos

import android.util.Log
import com.example.newsappmvvm.data.api.Client
import com.example.newsappmvvm.data.models.NewsBase
import retrofit2.Response

object NewsRepo {
    suspend fun getNews():Response<NewsBase>{
        val temp=Client.api.getUsers("mashable", "top", "4c187ad85bb84a0387872cff262a4afa")
        Log.i("working NewsRepo","${temp.toString()}")
        return  temp
    }

}