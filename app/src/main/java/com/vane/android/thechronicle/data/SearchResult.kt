package com.vane.android.thechronicle.data

import androidx.room.Entity

@Entity(tableName = "search_results", primaryKeys = ["searchQuery", "articleUrl"])
data class SearchResult(
    val searchQuery: String,
    val articleUrl: String,
    val queryPosition: Int
)
