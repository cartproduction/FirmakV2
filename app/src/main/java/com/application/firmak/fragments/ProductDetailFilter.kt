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
import com.application.firmak.adapters.PaidTypeRecyclerViewAdapter
import com.application.firmak.models.ProductItem
import kotlinx.android.synthetic.main.productdetail.*

class ProductDetailFilter: Fragment() {

    private var productArray: ArrayList<ProductItem> = ArrayList<ProductItem>()
    private var productAdapter: PaidTypeRecyclerViewAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.productdetailfilter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initMenuRecycleView()

    }

    private fun initMenuRecycleView() {

        /*val lp2 = imageView.layoutParams as ViewGroup.LayoutParams
        lp2.height = ApplicationClass.height / 2
        lp2.width = ApplicationClass.width / 2
        imageView.layoutParams = lp2*/

        val item1 = ProductItem("Davlunbaz", "3 Katlı, Mayalandırma Odalı, Dijital Panel, Hava Klapesi, Sİyah Ön Görünüm, Davlumbaz.", "02.03.2018", R.mipmap.checked, R.mipmap.ic_launcher, R.mipmap.ic_launcher)
        val item2 = ProductItem("Hava Klapesi", "3 Katlı, Mayalandırma Odalı, Dijital Panel, Hava Klapesi, Sİyah Ön Görünüm, Davlumbaz.", "02.03.2018", R.mipmap.checked, R.mipmap.ic_launcher, R.mipmap.ic_launcher)

        productArray.clear()
        productArray.add(item1)
        productArray.add(item2)
        docs!!.addItemDecoration(DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL))
        productAdapter = PaidTypeRecyclerViewAdapter(productArray, requireContext())
        val gridLayoutManager = GridLayoutManager(requireContext(), 1)
        docs!!.layoutManager = gridLayoutManager
        docs!!.adapter = productAdapter

    }


}