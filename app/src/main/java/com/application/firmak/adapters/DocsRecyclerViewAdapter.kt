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
import kotlinx.android.synthetic.main.itemmenu.view.*
import com.application.firmak.ApplicationClass



class DocsRecyclerViewAdapter(val horizontalGrocderyList: List<ProductItem>, internal var context: Context) : RecyclerView.Adapter<DocsRecyclerViewAdapter.GroceryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroceryViewHolder {
        //inflate the layout file
        val groceryProductView = LayoutInflater.from(parent.context).inflate(R.layout.itemmenu, parent, false)
        return GroceryViewHolder(groceryProductView)
    }

    override fun onBindViewHolder(holder: GroceryViewHolder, position: Int) {

        val lp2 = holder.productimage.layoutParams as ViewGroup.LayoutParams
        lp2.width = ApplicationClass.width / 2
        holder.productimage.layoutParams = lp2

        Picasso.with(context).load(horizontalGrocderyList[position].profilePictureUrl!!).into(holder.productimage)
        holder.title.setText(horizontalGrocderyList[position].name)
        holder.badgeback.visibility = View.INVISIBLE
        holder.badge.visibility = View.INVISIBLE


    }
    override fun getItemCount(): Int {
        return horizontalGrocderyList.size
    }

    inner class GroceryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        internal var productimage: ImageView
        internal var title: TextView
        internal var badge: TextView
        internal var badgeback: ImageView

        init {
            title = view.textView2
            badge = view.textView14
            productimage = view.imageView
            badgeback = view.imageView3
        }
    }
}