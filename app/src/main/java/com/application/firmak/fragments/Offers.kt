package com.application.firmak

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.application.firmak.FimakApp.Companion.addMainFragment
import com.application.firmak.adapters.OffersRecyclerViewAdapter
import com.application.firmak.adapters.OrdersRecyclerViewAdapter
import iammert.com.expandablelib.ExpandableLayout
import iammert.com.expandablelib.Section
import kotlinx.android.synthetic.main.layout_child.view.*
import kotlinx.android.synthetic.main.layout_header.view.*
import kotlinx.android.synthetic.main.urunlerim.*
import com.application.firmak.models.ProductItem
import com.squareup.picasso.Picasso
import iammert.com.expandablelib.ExpandCollapseListener
import kotlinx.android.synthetic.main.offers.*


class Offers: Fragment() {

    private var onaybekleyenproductArray: ArrayList<ProductItem> = ArrayList<ProductItem>()
    private var onaybekleyenproductAdapter: OffersRecyclerViewAdapter? = null

    private var onayladigimproductArray: ArrayList<ProductItem> = ArrayList<ProductItem>()
    private var onayladigimproductAdapter: OffersRecyclerViewAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        return inflater!!.inflate(R.layout.offers, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        initExpandableLayouts()
    }

    private fun initExpandableLayouts() {
        onaybekleyen.setRenderer(object : ExpandableLayout.Renderer<String, String> {
            override fun renderParent(view: View, model: String, isExpanded: Boolean, parentPosition: Int) {

                view.tvParent.setText(R.string.onaybekleyen)
                Picasso.with(context).load(R.mipmap.timeicon).into(view.imageView11)
                if(isExpanded)
                    Picasso.with(context).load(R.mipmap.uppicon).into(view.imageView12)
                else
                    Picasso.with(context).load(R.mipmap.righticon).into(view.imageView12)
            }

            override fun renderChild(view: View, model: String, parentPosition: Int, childPosition: Int) {

                val item1 = ProductItem("3 Adet Ürün", "50.000 TL", "Nakit", R.mipmap.ordericon, R.mipmap.ic_launcher, R.mipmap.ic_launcher)
                val item2 = ProductItem("3 Adet Ürün", "50.000 TL", "Nakit", R.mipmap.ordericon, R.mipmap.ic_launcher, R.mipmap.ic_launcher)
                onaybekleyenproductArray.clear()
                onaybekleyenproductArray.add(item1)
                onaybekleyenproductArray.add(item2)

                view.createdordersrec.addItemDecoration(DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL))
                onaybekleyenproductAdapter = OffersRecyclerViewAdapter(onaybekleyenproductArray, requireContext(),requireFragmentManager())
                val gridLayoutManager = GridLayoutManager(requireContext(), 1)
                view.createdordersrec.layoutManager = gridLayoutManager
                view.createdordersrec.adapter = onaybekleyenproductAdapter


            }
        })

        onaybekleyen.setExpandListener(ExpandCollapseListener.ExpandListener<Any> { parentIndex, parent, view ->
            Picasso.with(context).load(R.mipmap.uppicon).into(view.imageView12)

        })

        onaybekleyen.setCollapseListener(ExpandCollapseListener.CollapseListener<Any> { parentIndex, parent, view ->
            Picasso.with(context).load(R.mipmap.righticon).into(view.imageView12)
        })

        val onaybekleyensection = Section<String, String>()
        val onaybekleyenparent = ""
        val onaybekleyenchild = ""

        onaybekleyensection.parent = onaybekleyenparent
        onaybekleyensection.children.add(onaybekleyenchild)
        onaybekleyensection.expanded = true
        onaybekleyen.addSection(onaybekleyensection)

        onayladigim.setRenderer(object : ExpandableLayout.Renderer<String, String> {
            override fun renderParent(view: View, model: String, isExpanded: Boolean, parentPosition: Int) {

                view.tvParent.setText(R.string.onayladiklarim)
                Picasso.with(context).load(R.mipmap.onay).into(view.imageView11)
                if(isExpanded)
                    Picasso.with(context).load(R.mipmap.uppicon).into(view.imageView12)
                else
                    Picasso.with(context).load(R.mipmap.righticon).into(view.imageView12)
            }

            override fun renderChild(view: View, model: String, parentPosition: Int, childPosition: Int) {

                val item1 = ProductItem("3 Adet Ürün", "50.000 TL", "Nakit", R.mipmap.ordericon, R.mipmap.ic_launcher, R.mipmap.ic_launcher)
                val item2 = ProductItem("3 Adet Ürün", "50.000 TL", "Nakit", R.mipmap.ordericon, R.mipmap.ic_launcher, R.mipmap.ic_launcher)
                onayladigimproductArray.clear()
                onayladigimproductArray.add(item1)
                onayladigimproductArray.add(item2)

                view.createdordersrec.addItemDecoration(DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL))
                onayladigimproductAdapter = OffersRecyclerViewAdapter(onayladigimproductArray,requireContext(),requireFragmentManager())
                val gridLayoutManager = GridLayoutManager(requireContext(), 1)
                view.createdordersrec.layoutManager = gridLayoutManager
                view.createdordersrec.adapter = onayladigimproductAdapter


            }
        })

        onayladigim.setExpandListener(ExpandCollapseListener.ExpandListener<Any> { parentIndex, parent, view ->
            Picasso.with(context).load(R.mipmap.uppicon).into(view.imageView12)

        })

        onayladigim.setCollapseListener(ExpandCollapseListener.CollapseListener<Any> { parentIndex, parent, view ->
            Picasso.with(context).load(R.mipmap.righticon).into(view.imageView12)
        })

        val onayladigimsection = Section<String, String>()
        val onayladigimparent = ""
        val onayladigimchild = ""

        onayladigimsection.parent = onayladigimparent
        onayladigimsection.children.add(onayladigimchild)
        onayladigimsection.expanded = true
        onayladigim.addSection(onayladigimsection)


    }


}