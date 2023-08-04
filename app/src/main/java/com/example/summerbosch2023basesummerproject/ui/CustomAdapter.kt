package com.example.summerbosch2023basesummerproject.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.summerbosch2023basesummerproject.MainActivity
import com.example.summerbosch2023basesummerproject.Pokemon
import com.example.summerbosch2023basesummerproject.R
import com.squareup.picasso.Picasso

class CustomAdapter(private val mList: List<Pokemon>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_item, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]

        // sets the image to the imageview from our itemHolder class

        Picasso
            .get()
            .load(MainActivity.Users.activePokemon!!.url)
            .into(holder.imageView);

        // sets the text to the textview from our itemHolder class
        holder.nameView.text = ItemsViewModel.name

        holder.descriptionView.text = ItemsViewModel.description

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView3)
        val nameView: TextView = itemView.findViewById(R.id.nameTextView8)
        val descriptionView: TextView = itemView.findViewById(R.id.descriptionTextView10)
    }
}