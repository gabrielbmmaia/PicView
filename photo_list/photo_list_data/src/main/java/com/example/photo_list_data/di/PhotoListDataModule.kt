package com.example.photo_list_data.di

import android.app.Application
import android.util.Log
import androidx.room.Room
import com.example.photo_list_data.local.FavoriteDatabase
import com.example.photo_list_data.remote.UnsplashApi
import com.example.photo_list_data.repository.UnsplashImageRepositoryImpl
import com.example.photo_list_domain.repository.UnsplashImageRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PhotoListDataModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor {
            Log.i("OK_HTTP", it)
        }.apply { level = HttpLoggingInterceptor.Level.BODY }

        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideUnsplashApi(client: OkHttpClient): UnsplashApi {
        return Retrofit.Builder()
            .baseUrl(UnsplashApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create()
    }


    @Provides
    @Singleton
    fun provideUnsplashImageRepository(
        unsplashApi: UnsplashApi
    ): UnsplashImageRepository {
        return UnsplashImageRepositoryImpl(
            unsplashApi = unsplashApi
        )
    }

    @Provides
    @Singleton
    fun provideFavoriteDatabase(app: Application): FavoriteDatabase {
        return Room.databaseBuilder(
            app,
            FavoriteDatabase::class.java,
            "favorite_db"
        ).build()
    }
}