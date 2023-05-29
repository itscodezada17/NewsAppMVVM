package com.example.newsappmvvm.data.models

data class News(
    val publishedAt: String? = null,
    val author: String? = null,
    val urlToImage: String? = null,
    val description: String? = null,
    val source: Source? = null,
    val title: String? = null,
    val url: String? = null,
    val content: String? = null
)

data class NewsBase(
    val status: String? = null,
    val source: String? = null,
    val sortBy: String? = null,
    val articles: List<News>? = null
)

data class Source(
    val name: String? = null,
    val id: String? = null
)

