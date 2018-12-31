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
import iammert.com.expandablelib.ExpandableLayout
import iammert.com.expandablelib.Section
import kotlinx.android.synthetic.main.layout_child.view.*
import kotlinx.android.synthetic.main.layout_header.view.*
import kotlinx.android.synthetic.main.urunlerim.*
import com.application.firmak.adapters.ProductRecyclerViewAdapter
import com.application.firmak.adapters.TeslimEdilecekProductRecyclerViewAdapter
import com.application.firmak.models.ProductItem
import com.squareup.picasso.Picasso
import iammert.com.expandablelib.ExpandCollapseListener




class Products: Fragment() {

    private var productArray: ArrayList<ProductItem> = ArrayList<ProductItem>()
    private var productAdapter: ProductRecyclerViewAdapter? = null

    private var teslimEdilecekproductArray: ArrayList<ProductItem> = ArrayList<ProductItem>()
    private var teslimEdilecekproductAdapter: TeslimEdilecekProductRecyclerViewAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        return inflater!!.inflate(R.layout.urunlerim, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initProductRecycleView()

        initExpandableLayouts()
    }

    private fun initExpandableLayouts() {
        teslimedilecekexp.setRenderer(object : ExpandableLayout.Renderer<String, String> {
            override fun renderParent(view: View, model: String, isExpanded: Boolean, parentPosition: Int) {

                view.tvParent.setText(R.string.teslimedilecek)
                Picasso.with(context).load(R.mipmap.timeicon).into(view.imageView11)
                if(isExpanded)
                    Picasso.with(context).load(R.mipmap.uppicon).into(view.imageView12)
                else
                    Picasso.with(context).load(R.mipmap.righticon).into(view.imageView12)
            }

            override fun renderChild(view: View, model: String, parentPosition: Int, childPosition: Int) {

                val item1 = ProductItem("Estone 300", "3 Katlı, Mayalandırma Odalı, Dijital Panel, Hava Klapesi, Sİyah Ön Görünüm, Davlumbaz.", "02.03.2018", R.mipmap.estone, R.mipmap.ic_launcher, R.mipmap.ic_launcher)
                val item2 = ProductItem("Rokon", "3 Katlı, Mayalandırma Odalı, Dijital Panel, Hava Klapesi, Sİyah Ön Görünüm, Davlumbaz.", "02.03.2018", R.mipmap.rokon, R.mipmap.ic_launcher, R.mipmap.ic_launcher)
                teslimEdilecekproductArray.clear()
                teslimEdilecekproductArray.add(item1)
                teslimEdilecekproductArray.add(item2)

                view.createdordersrec.addItemDecoration(DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL))
                teslimEdilecekproductAdapter = TeslimEdilecekProductRecyclerViewAdapter(teslimEdilecekproductArray, requireContext())
                val gridLayoutManager = GridLayoutManager(requireContext(), 1)
                view.createdordersrec.layoutManager = gridLayoutManager
                view.createdordersrec.adapter = teslimEdilecekproductAdapter

                ItemClickSupport.addTo(view.createdordersrec).setOnItemClickListener { recyclerView, position, v ->
                    addMainFragment(requireFragmentManager(),ProductDetail(), true, "ProductDetail")
                }


            }
        })

        teslimedilecekexp.setExpandListener(ExpandCollapseListener.ExpandListener<Any> { parentIndex, parent, view ->
            Picasso.with(context).load(R.mipmap.uppicon).into(view.imageView12)

        })

        teslimedilecekexp.setCollapseListener(ExpandCollapseListener.CollapseListener<Any> { parentIndex, parent, view ->
            Picasso.with(context).load(R.mipmap.righticon).into(view.imageView12)
        })

        val teslimatsection = Section<String, String>()
        val teslimatparent = ""
        val teslimatchild = ""

        teslimatsection.parent = teslimatparent
        teslimatsection.children.add(teslimatchild)
        teslimatsection.expanded = true
        teslimedilecekexp.addSection(teslimatsection)


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

        product!!.addItemDecoration(DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL))
        productAdapter = ProductRecyclerViewAdapter(productArray, requireContext())
        val gridLayoutManager = GridLayoutManager(requireContext(), 1)
        product!!.layoutManager = gridLayoutManager
        product!!.adapter = productAdapter

        ItemClickSupport.addTo(product).setOnItemClickListener { product, position, v ->
            addMainFragment(requireFragmentManager(),ProductDetail(), true, "ProductDetail")
        }

    }


}