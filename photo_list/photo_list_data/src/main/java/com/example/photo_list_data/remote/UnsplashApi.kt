package com.example.photo_list_data.remote

import com.example.photo_list_data.remote.dtos.SearchRequest
import com.example.photo_list_data.remote.dtos.UnsplashImageDto
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface UnsplashApi {

    @Headers("Authorization: Client-ID $API_KEY")
    @GET("photos")
    suspend fun getPhotoList(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): List<UnsplashImageDto>

    @Headers("Authorization: Client-ID $API_KEY")
    @GET("/search/photos")
    suspend fun getSearchedPhotoList(
        @Query("query") query: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): SearchRequest

    @Headers("Authorization: Client-ID $API_KEY")
    @GET("/search/photos")
    suspend fun getSearchedPhotoList(
        @Query("query") query: String,
        @Query("color") color: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): SearchRequest

    companion object {
        const val BASE_URL = "https://api.unsplash.com/"
        const val PER_PAGE = 10
        private const val API_KEY = "TvSVNkSa494p9BFXTIqhYsO7spC7cNa6ewhU695aiNQ"
    }
}