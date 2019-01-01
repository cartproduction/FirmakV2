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
import kotlinx.android.synthetic.main.itemproduct.view.*

class ProductRecyclerViewAdapter(val horizontalGrocderyList: List<ProductItem>, internal var context: Context) : RecyclerView.Adapter<ProductRecyclerViewAdapter.GroceryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroceryViewHolder {
        //inflate the layout file
        val groceryProductView = LayoutInflater.from(parent.context).inflate(R.layout.itemproduct, parent, false)
        return GroceryViewHolder(groceryProductView)
    }

    override fun onBindViewHolder(holder: GroceryViewHolder, position: Int) {

        Picasso.with(context).load(horizontalGrocderyList[position].profilePictureUrl!!).into(holder.productimage)
        holder.title.setText(horizontalGrocderyList[position].name)
        holder.description.setText(horizontalGrocderyList[position].description)
        holder.date.setText(horizontalGrocderyList[position].date)
        val span = span {
            strikethrough { +horizontalGrocderyList[position].date!! }

        }
        holder.date.setText(span.build())
        holder.sample1.setShowMode(SwipeLayout.ShowMode.PullOut)
        val starBottView = holder.sample1.starbott
        //holder.sample1.addDrag(SwipeLayout.DragEdge.Left, holder.sample1.bottom_wrapper)
        holder.sample1.addDrag(SwipeLayout.DragEdge.Right, holder.sample1.bottom_wrapper_2)
        //holder.sample1.addDrag(SwipeLayout.DragEdge.Top, starBottView)
        //holder.sample1.addDrag(SwipeLayout.DragEdge.Bottom, starBottView)
        holder.sample1.addRevealListener(R.id.delete, SwipeLayout.OnRevealListener { child, edge, fraction, distance -> })

        holder.sample1.star2.setOnClickListener(View.OnClickListener {
            holder.sample1.close()
            notifyItemRemoved(position)
        })
        holder.sample1.magnifier2.setOnClickListener(View.OnClickListener { Toast.makeText(context, "Magnifier", Toast.LENGTH_SHORT).show() })

        holder.sample1.addRevealListener(R.id.starbott, SwipeLayout.OnRevealListener { child, edge, fraction, distance ->
            val star = child.star
            val d = (child.height / 2 - star.getHeight() / 2).toFloat()
            ViewHelper.setTranslationY(star, d * fraction)
            ViewHelper.setScaleX(star, fraction + 0.6f)
            ViewHelper.setScaleY(star, fraction + 0.6f)
        })

        holder.sample1.getSurfaceView().setOnClickListener(View.OnClickListener {


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
        internal var sample1: SwipeLayout
        init {
            title = view.textView2
            description = view.textView4
            date = view.textView14
            productimage = view.imageView
            sample1 = view.sample1
        }
    }
}