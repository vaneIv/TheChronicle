package com.vane.android.thechronicle.api

import com.vane.android.thechronicle.BuildConfig
import com.vane.android.thechronicle.api.model.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

/**
 * Used to connect to the News API to fetch news articles
 */
interface NewsApi {

    companion object {
        const val API_KEY = BuildConfig.NEWS_API_KEY
    }

    @Headers("X-API-Key: $API_KEY")
    @GET("v2/top-headlines?country=ud&pageSize=100")
    suspend fun getBreakingNews(
//        @Query("country") countryCode: String,
//        @Query("category") category: String,
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int
    ): NewsResponse

    @Headers("X-API-Key: $API_KEY")
    @GET("v2/everything")
    suspend fun searchNews(
        @Query("q") query: String,
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int
    ): NewsResponse
}