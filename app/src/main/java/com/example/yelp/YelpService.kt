package com.example.yelp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface YelpService {

    @GET("businesses/search")
    fun searchRestaurants( // function parameters
        @Header("Authorization") authHeader: String,
        @Query("term") searchTerm: String,
        @Query("location") location: String):
            // return type
            Call<YelpSearchResult> // Call any is the return type
}