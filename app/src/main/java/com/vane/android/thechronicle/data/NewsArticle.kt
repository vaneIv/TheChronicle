package com.vane.android.thechronicle.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.vane.android.thechronicle.api.model.Source

@Entity(tableName = "news_articles")
data class NewsArticle(
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String?,
    val source: Source?,
    val title: String?,
    @PrimaryKey val url: String,
    val urlToImage: String?,
    val isBookmarked: Boolean,
    val updateAt: Long = System.currentTimeMillis()
)
