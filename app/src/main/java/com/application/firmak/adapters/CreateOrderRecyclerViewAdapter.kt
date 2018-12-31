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
import kotlinx.android.synthetic.main.itemcooks.view.*
import android.R.attr.data



class CreateOrderRecyclerViewAdapter(val horizontalGrocderyList: List<ProductItem>, internal var context: Context) : RecyclerView.Adapter<CreateOrderRecyclerViewAdapter.GroceryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroceryViewHolder {
        //inflate the layout file
        val groceryProductView = LayoutInflater.from(parent.context).inflate(R.layout.itemcooks, parent, false)
        return GroceryViewHolder(groceryProductView)
    }

    override fun onBindViewHolder(holder: GroceryViewHolder, position: Int) {

        Picasso.with(context).load(horizontalGrocderyList[position].profilePictureUrl!!).into(holder.productimage)
        holder.title.setText(horizontalGrocderyList[position].name)
        holder.date.setText(horizontalGrocderyList[position].date)
        val span = span {
            strikethrough { +horizontalGrocderyList[position].date!! }

        }
        holder.date.setText(span.build())
        
        
    }

    override fun getItemCount(): Int {
        return horizontalGrocderyList.size
    }

    inner class GroceryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        internal var productimage: ImageView
        internal var title: TextView
        internal var date: TextView
        init {
            title = view.textView2
            date = view.textView14
            productimage = view.imageView
        }
    }
}