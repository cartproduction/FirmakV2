package com.application.firmak

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.application.firmak.adapters.DocsRecyclerViewAdapter
import com.application.firmak.adapters.MenuRecyclerViewAdapter
import com.application.firmak.models.ProductItem
import kotlinx.android.synthetic.main.productdetail.*

class ProductDetail: Fragment() {

    private var productArray: ArrayList<ProductItem> = ArrayList<ProductItem>()
    private var productAdapter: DocsRecyclerViewAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.productdetail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initMenuRecycleView()

    }

    private fun initMenuRecycleView() {

        val item1 = ProductItem("Teknik Dökümanı", "", " ", R.mipmap.pdficon, R.mipmap.ic_launcher, R.mipmap.ic_launcher)
        val item2 = ProductItem("Extra Aksesuar Dökümanı", "", " ", R.mipmap.pdficon, R.mipmap.ic_launcher, R.mipmap.ic_launcher)
        val item3 = ProductItem("Montaj Bilgileri", "", " ", R.mipmap.pdficon, R.mipmap.ic_launcher, R.mipmap.ic_launcher)
        val item4 = ProductItem("Montaj Bilgileri", "", " ", R.mipmap.pdficon, R.mipmap.ic_launcher, R.mipmap.ic_launcher)
        val item5 = ProductItem("Montaj Bilgileri", "", " ", R.mipmap.pdficon, R.mipmap.ic_launcher, R.mipmap.ic_launcher)
        val item6 = ProductItem("Montaj Bilgileri", "", " ", R.mipmap.pdficon, R.mipmap.ic_launcher, R.mipmap.ic_launcher)

        productArray.clear()
        productArray.add(item1)
        productArray.add(item2)
        productArray.add(item3)
        productArray.add(item4)
        productArray.add(item5)
        productArray.add(item6)
        docs!!.addItemDecoration(DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL))
        productAdapter = DocsRecyclerViewAdapter(productArray, requireContext())
        val gridLayoutManager = GridLayoutManager(requireContext(), 1)
        docs!!.layoutManager = gridLayoutManager
        docs!!.adapter = productAdapter

    }


}