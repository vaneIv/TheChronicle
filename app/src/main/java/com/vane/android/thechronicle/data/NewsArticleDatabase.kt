package com.vane.android.thechronicle.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.vane.android.thechronicle.utils.Converters

@Database(
    entities = [
        NewsArticle::class,
        BreakingNews::class,
        SearchResult::class,
        SearchQueryRemoteKey::class
    ],
    version = 1
)
@TypeConverters(Converters::class)
abstract class NewsArticleDatabase : RoomDatabase() {

    abstract fun newsArticleDao(): NewsArticleDao
}