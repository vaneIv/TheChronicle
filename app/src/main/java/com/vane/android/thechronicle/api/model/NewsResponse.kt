package com.vane.android.thechronicle.api.model

data class NewsResponse(
    val articles: List<NewsArticleDto>,
    val status: String,
    val totalResults: Int
)