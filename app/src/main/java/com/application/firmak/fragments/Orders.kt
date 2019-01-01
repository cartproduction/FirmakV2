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
import com.application.firmak.adapters.OrdersRecyclerViewAdapter
import iammert.com.expandablelib.ExpandableLayout
import com.application.firmak.models.ProductItem
import kotlinx.android.synthetic.main.orders.*


class Orders: Fragment() {

    private var productArray: ArrayList<ProductItem> = ArrayList<ProductItem>()
    private var productAdapter: OrdersRecyclerViewAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        return inflater!!.inflate(R.layout.orders, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initProductRecycleView()

    }

    private fun initProductRecycleView() {

        val item1 = ProductItem("Estone 300", "3 Katlı, Mayalandırma Odalı, Dijital Panel, Hava Klapesi, Sİyah Ön Görünüm, Davlumbaz.", "02.03.2018", R.mipmap.estone, R.mipmap.ic_launcher, R.mipmap.ic_launcher)
        val item2 = ProductItem("Rokon", "3 Katlı, Mayalandırma Odalı, Dijital Panel, Hava Klapesi, Sİyah Ön Görünüm, Davlumbaz.", "02.03.2018", R.mipmap.rokon, R.mipmap.ic_launcher, R.mipmap.ic_launcher)
        val item3 = ProductItem("Estone 300", "3 Katlı, Mayalandırma Odalı, Dijital Panel, Hava Klapesi, Sİyah Ön Görünüm, Davlumbaz.", "02.03.2018", R.mipmap.estone, R.mipmap.ic_launcher, R.mipmap.ic_launcher)
        val item4 = ProductItem("Rokon", "3 Katlı, Mayalandırma Odalı, Dijital Panel, Hava Klapesi, Sİyah Ön Görünüm, Davlumbaz.", "02.03.2018", R.mipmap.rokon, R.mipmap.ic_launcher, R.mipmap.ic_launcher)
        val item5 = ProductItem("Estone 300", "3 Katlı, Mayalandırma Odalı, Dijital Panel, Hava Klapesi, Sİyah Ön Görünüm, Davlumbaz.", "02.03.2018", R.mipmap.estone, R.mipmap.ic_launcher, R.mipmap.ic_launcher)
        val item6 = ProductItem("Rokon", "3 Katlı, Mayalandırma Odalı, Dijital Panel, Hava Klapesi, Sİyah Ön Görünüm, Davlumbaz.", "02.03.2018", R.mipmap.rokon, R.mipmap.ic_launcher, R.mipmap.ic_launcher)

        productArray.clear()
        productArray.add(item1)
        productArray.add(item2)
        productArray.add(item3)
        productArray.add(item4)
        productArray.add(item5)
        productArray.add(item6)

        orders!!.addItemDecoration(DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL))
        productAdapter = OrdersRecyclerViewAdapter(productArray, requireContext())
        val gridLayoutManager = GridLayoutManager(requireContext(), 1)
        orders!!.layoutManager = gridLayoutManager
        orders!!.adapter = productAdapter


    }


}