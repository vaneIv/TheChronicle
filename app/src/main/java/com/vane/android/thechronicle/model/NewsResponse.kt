package com.vane.android.thechronicle.model

data class NewsResponse(
    val articles: MutableList<NewsArticle>,
    val status: String,
    val totalResults: Int
)