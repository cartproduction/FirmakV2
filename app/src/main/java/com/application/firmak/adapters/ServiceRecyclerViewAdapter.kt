package com.application.firmak.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.text.style.StrikethroughSpan
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.application.firmak.models.ProductItem
import com.application.firmak.R
import com.application.firmak.span
import com.daimajia.swipe.SwipeLayout
import com.nineoldandroids.view.ViewHelper
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.itemservice.view.*

class ServiceRecyclerViewAdapter(val horizontalGrocderyList: List<ProductItem>, internal var context: Context) : RecyclerView.Adapter<ServiceRecyclerViewAdapter.GroceryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroceryViewHolder {
        //inflate the layout file
        val groceryProductView = LayoutInflater.from(parent.context).inflate(R.layout.itemservice, parent, false)
        return GroceryViewHolder(groceryProductView)
    }

    override fun onBindViewHolder(holder: GroceryViewHolder, position: Int) {


        holder.title.setText(horizontalGrocderyList[position].name)
        holder.description.setText(horizontalGrocderyList[position].description)
        
        
    }

    override fun getItemCount(): Int {
        return horizontalGrocderyList.size
    }

    inner class GroceryViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        internal var title: TextView
        internal var description: TextView
        internal var sample1: SwipeLayout
        init {
            title = view.textView2
            description = view.textView4
            sample1 = view.sample1
        }
    }
}