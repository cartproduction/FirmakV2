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
import com.application.firmak.adapters.ProductCategoryRecyclerViewAdapter
import com.application.firmak.models.ProductItem
import kotlinx.android.synthetic.main.menu.*

class ProductCategory: Fragment() {

    private var productArray: ArrayList<ProductItem> = ArrayList<ProductItem>()
    private var productAdapter: ProductCategoryRecyclerViewAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initMenuRecycleView()

    }

    private fun initMenuRecycleView() {

        val item1 = ProductItem("Pişirme Grubu", "", " ", R.mipmap.pisirme, R.mipmap.ic_launcher, R.mipmap.ic_launcher)
        val item2 = ProductItem("Gastro Grubu", "", " ", R.mipmap.gastro, R.mipmap.ic_launcher, R.mipmap.ic_launcher)
        val item3 = ProductItem("Yoğurma Grubu", "", " ", R.mipmap.yogurma, R.mipmap.ic_launcher, R.mipmap.ic_launcher)
        val item4 = ProductItem("İşleme Grubu", "", " ", R.mipmap.isleme, R.mipmap.ic_launcher, R.mipmap.ic_launcher)
        val item5 = ProductItem("Yardımcı Ekipmanlar", "", " ", R.mipmap.ekipman, R.mipmap.ic_launcher, R.mipmap.ic_launcher)

        productArray.clear()
        productArray.add(item1)
        productArray.add(item2)
        productArray.add(item3)
        productArray.add(item4)
        productArray.add(item5)

        menulist!!.addItemDecoration(DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL))
        productAdapter = ProductCategoryRecyclerViewAdapter(productArray, requireContext())
        val gridLayoutManager = GridLayoutManager(requireContext(), 1)
        menulist!!.layoutManager = gridLayoutManager
        menulist!!.adapter = productAdapter

    }


}