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
    @SerializedName("review_count") val numReviews: Int,
    @SerializedName("distance") val distanceInMeters: Double,
    @SerializedName("image_url") val image_url: String,
    val categories: List<YelpCategories>,
    val location: YelpLocation
) {
    fun displayDistance(): String {
        val milesPerMeter =  0.000621371;
        val distanceInMiles = "%.2f".format(distanceInMeters * milesPerMeter)
        return "$distanceInMiles mi"
    }
}

data class YelpCategories(
    val title: String
)

data class YelpLocation(
    @SerializedName("address1") val address: String
)