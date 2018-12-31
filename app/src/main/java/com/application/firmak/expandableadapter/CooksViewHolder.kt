package com.application.firmak.expandableadapter

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.application.firmak.models.ProductItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.itemcooks.view.*

class CooksViewHolder(itemView: View) : ChildViewHolder(itemView) {

    internal var productimage: ImageView
    internal var title: TextView
    internal var number: TextView

    init {
        title = itemView.textView2
        number = itemView.textView14
        productimage = itemView.imageView
    }

    fun bind(Cooks: ProductItem,context: Context) {

        title.setText(Cooks.name)
        number.setText(Cooks.date)
        Picasso.with(context).load(Cooks.profilePictureUrl!!).into(productimage)

    }
}