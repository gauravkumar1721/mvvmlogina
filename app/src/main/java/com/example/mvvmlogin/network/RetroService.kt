package com.example.mvvmlogin.network

import com.example.mvvmlogin.RecyclerList
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroService {

    @GET("repositories")
    fun getDataFromAPI(@Query("q") query: String): Call<RecyclerList>

}