package com.dynast.calendar.data

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("/hello")
    suspend fun getHello(): Response<String>

}