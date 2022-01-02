package com.vane.android.thechronicle.di

import android.app.Application
import androidx.room.Room
import com.vane.android.thechronicle.data.NewsArticleDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application): NewsArticleDatabase =
        Room.databaseBuilder(app, NewsArticleDatabase::class.java, "news_article_database")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun provideNewsArticleDao(db: NewsArticleDatabase) = db.newsArticleDao()
}