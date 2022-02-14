package com.example.yelp

import com.google.gson.annotations.SerializedName

data class YelpSearchResult(
    @SerializedName("total") val total: Int,
    @SerializedName("businesses") val restaurants: List<YelpRestaurants>
)

data class YelpRestaurants(
    // var name != json object name -> You need serialized annotation, else not.
    val name: String,
    val rating: Double,
    val price: String,
    @SerializedName("url") val website: String,
    @SerializedName("image_url") val image_url: String,

)