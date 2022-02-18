package com.example.yelp

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.target.Target


class RestaurantsAdapter(private val context: Context, private val restaurants: MutableList<YelpRestaurants>) :
    RecyclerView.Adapter<RestaurantsAdapter.ViewHolder> (){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_restaurant, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val restaurant = restaurants[position]
        holder.bind(restaurant)
    }

    override fun getItemCount() = restaurants.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//
        private val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        private val tvNumReviews: TextView = itemView.findViewById(R.id.tvNumReviews)
        private val tvAddress: TextView = itemView.findViewById(R.id.tvAddress)
        private val tvCategory: TextView = itemView.findViewById(R.id.tvCategory)
        private val tvDistance: TextView = itemView.findViewById(R.id.tvDistance)
        private val tvPrice: TextView = itemView.findViewById(R.id.tvPrice)
        private val ivImage: ImageView = itemView.findViewById(R.id.ivImage)
        private val ratingBar: RatingBar = itemView.findViewById(R.id.ratingBar)

        fun bind(restaurant: YelpRestaurants) {
            tvTitle.text = restaurant.name
            tvNumReviews.text = "${restaurant.numReviews} Reviews"
            tvAddress.text = restaurant.location.address
            tvCategory.text = restaurant.categories[0].title
            tvDistance.text = restaurant.displayDistance()
            tvPrice.text = restaurant.price
            ratingBar.rating = restaurant.rating.toFloat()

            val radius = 25 // corner radius, higher value = more rounded
            Glide.with(context)
                .load(restaurant.image_url)
                .transform(CenterCrop(), RoundedCorners(25))
                .into(ivImage)




        }

    }
}
