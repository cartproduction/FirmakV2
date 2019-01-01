package com.application.firmak.adapters

import android.content.Context
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.application.firmak.FimakApp.Companion.addMainFragment
import com.application.firmak.OffersSummary
import com.application.firmak.ProductDetail
import com.application.firmak.models.ProductItem
import com.application.firmak.R
import com.application.firmak.span
import com.daimajia.swipe.SwipeLayout
import com.nineoldandroids.view.ViewHelper
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.itemoffers.view.*


class OffersRecyclerViewAdapter(val horizontalGrocderyList: List<ProductItem>, internal var context: Context,var fragmentManager: FragmentManager) : RecyclerView.Adapter<OffersRecyclerViewAdapter.GroceryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroceryViewHolder {
        //inflate the layout file
        val groceryProductView = LayoutInflater.from(parent.context).inflate(R.layout.itemoffers, parent, false)
        return GroceryViewHolder(groceryProductView)
    }

    override fun onBindViewHolder(holder: GroceryViewHolder, position: Int) {

        Picasso.with(context).load(horizontalGrocderyList[position].profilePictureUrl!!).into(holder.productimage)
        holder.title.setText(horizontalGrocderyList[position].name)
        holder.description.setText(horizontalGrocderyList[position].description)
        holder.text3.setText(horizontalGrocderyList[position].description)
        holder.date.setText(horizontalGrocderyList[position].date)
        holder.sample1.setShowMode(SwipeLayout.ShowMode.PullOut)
        val starBottView = holder.sample1.starbott
        //holder.sample1.addDrag(SwipeLayout.DragEdge.Left, holder.sample1.bottom_wrapper)
        holder.sample1.addDrag(SwipeLayout.DragEdge.Right, holder.sample1.bottom_wrapper_2)
        //holder.sample1.addDrag(SwipeLayout.DragEdge.Top, starBottView)
        //holder.sample1.addDrag(SwipeLayout.DragEdge.Bottom, starBottView)
        holder.sample1.addRevealListener(R.id.delete, SwipeLayout.OnRevealListener { child, edge, fraction, distance -> })

        holder.sample1.star2.setOnClickListener(View.OnClickListener {
            notifyItemRemoved(position)
        })

        holder.sample1.magnifier2.setOnClickListener(View.OnClickListener {
            Toast.makeText(context, "Magnifier", Toast.LENGTH_SHORT).show()
        })


        holder.sample1.getSurfaceView().setOnClickListener(View.OnClickListener {

            addMainFragment(fragmentManager, OffersSummary(), true, "OffersSummary")
        })
        
        
    }

    override fun getItemCount(): Int {
        return horizontalGrocderyList.size
    }

    inner class GroceryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        internal var productimage: ImageView
        internal var title: TextView
        internal var description: TextView
        internal var date: TextView
        internal var text3: TextView
        internal var sample1: SwipeLayout
        init {
            title = view.textView2
            description = view.textView4
            text3 = view.textView14
            date = view.dateoffers
            productimage = view.imageView
            sample1 = view.sample1
        }
    }
}