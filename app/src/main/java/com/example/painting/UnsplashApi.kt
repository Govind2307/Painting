package com.example.painting

import com.example.painting.datafiles.DataItem
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface UnsplashApi {

    @GET("photos/")
    suspend fun getData(@Query("client_id")key:String ,@Query("page") page: Int): Response<List<DataItem>>

    companion object  {
        fun create():UnsplashApi{
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level=HttpLoggingInterceptor.Level.BASIC
            val client = OkHttpClient().newBuilder().addInterceptor(loggingInterceptor)

            return Retrofit.Builder()
                .baseUrl("https://api.unsplash.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client.build())
                .build()
                .create( UnsplashApi::class.java )

        }
    }
}