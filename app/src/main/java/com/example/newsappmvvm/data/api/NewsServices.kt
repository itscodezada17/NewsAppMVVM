package com.example.newsappmvvm.data.api

import com.example.newsappmvvm.data.models.News
import com.example.newsappmvvm.data.models.NewsBase
import com.google.gson.JsonObject
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface NewsServices {

   // @Headers("api-key: " + "4c187ad85bb84a0387872cff262a4afa")
   // @GET("v1/articles?source=mashable&sortBy=top&apiKey=4c187ad85bb84a0387872cff262a4af")
   // suspend fun getNews():Response<List<News>>

    @GET("articles")
    suspend fun getUsers(
        @Query("source") source: String,
        @Query("sortBy") sortBy: String,
        @Query("apiKey") apiKey: String
    ): Response<NewsBase>

}
