package com.example.painting

import com.example.painting.datafiles.DataItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface UnsplashApi {

    @GET("/photos")
    suspend fun getData(@Query("XSgz-lyCI_peixQ5kIwO5hMVJmBYJvNEigoMU2n1RF")key:String ,@Query("page") page: Int): Response<List<DataItem>>

}