package com.application.firmak

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.application.firmak.adapters.MenuRecyclerViewAdapter
import com.application.firmak.adapters.PaymentPlanRecyclerViewAdapter
import com.application.firmak.models.ProductItem
import kotlinx.android.synthetic.main.menu.*

class PaymentPlan: Fragment() {

    private var productArray: ArrayList<ProductItem> = ArrayList<ProductItem>()
    private var productAdapter: PaymentPlanRecyclerViewAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initMenuRecycleView()

    }

    private fun initMenuRecycleView() {

        val item1 = ProductItem("Nakit", "", " ", R.mipmap.profile, R.mipmap.ic_launcher, R.mipmap.ic_launcher)
        val item2 = ProductItem("Nakit", "", " ", R.mipmap.duyurular, R.mipmap.ic_launcher, R.mipmap.ic_launcher)
        val item3 = ProductItem("Nakit", "", " ", R.mipmap.bildirimler, R.mipmap.ic_launcher, R.mipmap.ic_launcher)
        val item4 = ProductItem("Nakit", "", " ", R.mipmap.servisgroup, R.mipmap.ic_launcher, R.mipmap.ic_launcher)
        val item5 = ProductItem("Nakit", "", " ", R.mipmap.hakkimizda, R.mipmap.ic_launcher, R.mipmap.ic_launcher)
        val item6 = ProductItem("Nakit", "", " ", R.mipmap.urunler, R.mipmap.ic_launcher, R.mipmap.ic_launcher)
        val item7 = ProductItem("Nakit", "", " ", R.mipmap.iletisim, R.mipmap.ic_launcher, R.mipmap.ic_launcher)

        productArray.clear()
        productArray.add(item1)
        productArray.add(item2)
        productArray.add(item3)
        productArray.add(item4)
        productArray.add(item5)
        productArray.add(item6)
        productArray.add(item7)

        menulist!!.addItemDecoration(DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL))
        productAdapter = PaymentPlanRecyclerViewAdapter(productArray, requireContext())
        val gridLayoutManager = GridLayoutManager(requireContext(), 1)
        menulist!!.layoutManager = gridLayoutManager
        menulist!!.adapter = productAdapter

    }


}