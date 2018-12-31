package com.application.firmak

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.application.firmak.expandableadapter.CooksCategory
import com.application.firmak.expandableadapter.CooksCategoryAdapter
import com.application.firmak.models.ProductItem
import kotlinx.android.synthetic.main.fragmentcooks_group.*
import java.util.*

class CooksGroup: Fragment() {

    private var productArray: ArrayList<ProductItem> = ArrayList<ProductItem>()
    private var productAdapter: CooksCategoryAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragmentcooks_group, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initCooksRecycleView()
    }

    private fun initCooksRecycleView() {

        /*val lp2 = imageView.layoutParams as ViewGroup.LayoutParams
        lp2.height = ApplicationClass.height / 2
        lp2.width = ApplicationClass.width / 2
        imageView.layoutParams = lp2*/

        val item1 = ProductItem("Roven 100G", "", "1 / 1", R.mipmap.pdficon, R.mipmap.ic_launcher, R.mipmap.ic_launcher)
        val item2 = ProductItem("Roven 150G", "", "4 / 2", R.mipmap.pdficon, R.mipmap.ic_launcher, R.mipmap.ic_launcher)
        val item3 = ProductItem("Roven 200G", "", "4 / 2", R.mipmap.pdficon, R.mipmap.ic_launcher, R.mipmap.ic_launcher)
        val item4 = ProductItem("Roven 200YC", "", "4 / 2", R.mipmap.pdficon, R.mipmap.ic_launcher, R.mipmap.ic_launcher)
        val item5 = ProductItem("Roven 200YC", "", "4 / 2", R.mipmap.pdficon, R.mipmap.ic_launcher, R.mipmap.ic_launcher)
        val item6 = ProductItem("Roven 200YC", "", "4 / 2", R.mipmap.pdficon, R.mipmap.ic_launcher, R.mipmap.ic_launcher)

        productArray.clear()
        productArray.add(item1)
        productArray.add(item2)
        productArray.add(item3)
        productArray.add(item4)
        productArray.add(item5)
        productArray.add(item6)

        val molvie_category_one = CooksCategory("ROVEN", productArray)
        val molvie_category_two = CooksCategory("ESTONE", productArray)
        val molvie_category_three = CooksCategory("ROKON", productArray)
        val molvie_category_four = CooksCategory("PIHESTO", productArray)

        val movieCategories = Arrays.asList(molvie_category_one, molvie_category_two, molvie_category_three, molvie_category_four)



        cooks!!.addItemDecoration(DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL))
        productAdapter = CooksCategoryAdapter(requireContext(), movieCategories)
        val gridLayoutManager = GridLayoutManager(requireContext(), 1)
        cooks!!.layoutManager = gridLayoutManager
        cooks!!.adapter = productAdapter

    }


}