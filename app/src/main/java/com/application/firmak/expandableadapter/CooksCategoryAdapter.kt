package com.application.firmak.expandableadapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.application.firmak.R
import com.application.firmak.models.ProductItem

class CooksCategoryAdapter(context: Context, parentItemList: List<ParentListItem>) : ExpandableRecyclerAdapter<CooksCategoryViewHolder, CooksViewHolder>(parentItemList) {

    private val mInflator: LayoutInflater
    var context: Context

    init {
        mInflator = LayoutInflater.from(context)
        this.context = context;
    }

    override fun onCreateParentViewHolder(parentViewGroup: ViewGroup): CooksCategoryViewHolder {
        val CooksCategoryView = mInflator.inflate(R.layout.cooks_header, parentViewGroup, false)
        return CooksCategoryViewHolder(CooksCategoryView)
    }

    override fun onCreateChildViewHolder(childViewGroup: ViewGroup): CooksViewHolder {
        val CooksView = mInflator.inflate(R.layout.itemcooks, childViewGroup, false)
        return CooksViewHolder(CooksView)
    }

    override fun onBindParentViewHolder(CooksCategoryViewHolder: CooksCategoryViewHolder, position: Int, parentListItem: ParentListItem) {
        val CooksCategory = parentListItem as CooksCategory
        CooksCategoryViewHolder.bind(CooksCategory,context)
    }

    override fun onBindChildViewHolder(CooksViewHolder: CooksViewHolder, position: Int, childListItem: Any) {
        val Cooks = childListItem as ProductItem
        CooksViewHolder.bind(Cooks,context)
    }
}