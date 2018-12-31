package com.application.firmak.expandableadapter

import android.content.Context
import android.view.View
import android.view.animation.RotateAnimation
import android.widget.ImageView
import android.widget.TextView
import com.application.firmak.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.cooks_header.view.*

class CooksCategoryViewHolder(itemView: View) : ParentViewHolder(itemView) {

    internal var productimage: ImageView
    internal var arrowicon: ImageView
    internal var title: TextView

    init {
        title = itemView.tvParent
        productimage = itemView.imageView11
        arrowicon = itemView.imageView12
    }

    fun bind(CooksCategory: CooksCategory,context: Context) {
        title.text = CooksCategory.name
        Picasso.with(context).load(R.mipmap.pdficon).into(productimage)
        Picasso.with(context).load(R.mipmap.uppicon).into(arrowicon)
    }

    override fun setExpanded(expanded: Boolean) {
        super.setExpanded(expanded)

        if (expanded) {
            arrowicon.rotation = ROTATED_POSITION
        } else {
            arrowicon.rotation = INITIAL_POSITION
        }

    }

    override fun onExpansionToggled(expanded: Boolean) {
        super.onExpansionToggled(expanded)

        val rotateAnimation: RotateAnimation
        if (expanded) { // rotate clockwise
            rotateAnimation = RotateAnimation(ROTATED_POSITION,
                    INITIAL_POSITION,
                    RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                    RotateAnimation.RELATIVE_TO_SELF, 0.5f)
        } else { // rotate counterclockwise
            rotateAnimation = RotateAnimation(-1 * ROTATED_POSITION,
                    INITIAL_POSITION,
                    RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                    RotateAnimation.RELATIVE_TO_SELF, 0.5f)
        }

        rotateAnimation.duration = 200
        rotateAnimation.fillAfter = true
        arrowicon.startAnimation(rotateAnimation)

    }

    companion object {

        private val INITIAL_POSITION = 0.0f
        private val ROTATED_POSITION = 180f
    }
}