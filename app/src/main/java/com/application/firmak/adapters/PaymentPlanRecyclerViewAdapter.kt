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
import kotlinx.android.synthetic.main.paymentplanitem.view.*

class PaymentPlanRecyclerViewAdapter(val horizontalGrocderyList: List<ProductItem>, internal var context: Context) : RecyclerView.Adapter<PaymentPlanRecyclerViewAdapter.GroceryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroceryViewHolder {
        //inflate the layout file
        val groceryProductView = LayoutInflater.from(parent.context).inflate(R.layout.paymentplanitem, parent, false)
        return GroceryViewHolder(groceryProductView)
    }

    override fun onBindViewHolder(holder: GroceryViewHolder, position: Int) {

        holder.text1.setText("1")
        holder.text2.setText(horizontalGrocderyList[position].name)
        holder.text3.setText(horizontalGrocderyList[position].name)
        holder.text4.setText(horizontalGrocderyList[position].name)
        holder.text5.setText(horizontalGrocderyList[position].name)


    }
    override fun getItemCount(): Int {
        return horizontalGrocderyList.size
    }

    inner class GroceryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        internal var text1: TextView
        internal var text2: TextView
        internal var text3: TextView
        internal var text4: TextView
        internal var text5: TextView

        init {
            text1 = view.textView11
            text2 = view.textView16
            text3 = view.textView2
            text4 = view.textView17
            text5 = view.textView18
        }
    }
}