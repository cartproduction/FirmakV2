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
import com.application.firmak.adapters.CreateOrderRecyclerViewAdapter
import com.application.firmak.adapters.OrdersRecyclerViewAdapter
import com.application.firmak.adapters.PaidTypeRecyclerViewAdapter
import iammert.com.expandablelib.ExpandableLayout
import iammert.com.expandablelib.Section
import kotlinx.android.synthetic.main.layout_child.view.*
import kotlinx.android.synthetic.main.layout_header.view.*
import kotlinx.android.synthetic.main.urunlerim.*
import com.application.firmak.models.ProductItem
import com.squareup.picasso.Picasso
import iammert.com.expandablelib.ExpandCollapseListener
import kotlinx.android.synthetic.main.createorder.*
import kotlinx.android.synthetic.main.createorderview.view.*


class CreateOrder: Fragment() {

    private var onaybekleyenproductArray: ArrayList<ProductItem> = ArrayList<ProductItem>()
    private var onaybekleyenproductAdapter: CreateOrderRecyclerViewAdapter? = null

    private var onayladigimproductArray: ArrayList<ProductItem> = ArrayList<ProductItem>()
    private var onayladigimproductAdapter: PaidTypeRecyclerViewAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.createorder, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        initExpandableLayouts()
    }

    private fun initExpandableLayouts() {


        createdorders.setRenderer(object : ExpandableLayout.Renderer<String, String> {
            override fun renderParent(view: View, model: String, isExpanded: Boolean, parentPosition: Int) {

                view.tvParent.setText(R.string.urunler)
                Picasso.with(context).load(R.mipmap.folder).into(view.imageView11)
                if(isExpanded)
                    Picasso.with(context).load(R.mipmap.uppicon).into(view.imageView12)
                else
                    Picasso.with(context).load(R.mipmap.righticon).into(view.imageView12)
            }

            override fun renderChild(view: View, model: String, parentPosition: Int, childPosition: Int) {

                val item1 = ProductItem("Estone 300", "3 Katlı, Mayalandırma Odalı, Dijital Panel, Hava Klapesi, Sİyah Ön Görünüm, Davlumbaz.", "02.03.2018", R.mipmap.estone, R.mipmap.ic_launcher, R.mipmap.ic_launcher)
                val item2 = ProductItem("Rokon", "3 Katlı, Mayalandırma Odalı, Dijital Panel, Hava Klapesi, Sİyah Ön Görünüm, Davlumbaz.", "02.03.2018", R.mipmap.rokon, R.mipmap.ic_launcher, R.mipmap.ic_launcher)
                onaybekleyenproductArray.clear()
                onaybekleyenproductArray.add(item1)
                onaybekleyenproductArray.add(item2)

                view.createdordersrec.addItemDecoration(DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL))
                onaybekleyenproductAdapter = CreateOrderRecyclerViewAdapter(onaybekleyenproductArray, requireContext())
                val gridLayoutManager = GridLayoutManager(requireContext(), 1)
                view.createdordersrec.layoutManager = gridLayoutManager
                view.createdordersrec.adapter = onaybekleyenproductAdapter

                ItemClickSupport.addTo(view.createdordersrec).setOnItemClickListener { recyclerView, position, v ->
                    addMainFragment(requireFragmentManager(),ProductDetail(), true, "ProductDetail")
                }
                Picasso.with(context).load(R.mipmap.buttonadd).into(view.imageView)
                view.textView2.setText(getString(R.string.urunekle))

            }
        })

        createdorders.setExpandListener(ExpandCollapseListener.ExpandListener<Any> { parentIndex, parent, view ->
            Picasso.with(context).load(R.mipmap.uppicon).into(view.imageView12)

        })

        createdorders.setCollapseListener(ExpandCollapseListener.CollapseListener<Any> { parentIndex, parent, view ->
            Picasso.with(context).load(R.mipmap.righticon).into(view.imageView12)
        })

        val onaybekleyensection = Section<String, String>()
        val onaybekleyenparent = ""
        val onaybekleyenchild = ""

        onaybekleyensection.parent = onaybekleyenparent
        onaybekleyensection.children.add(onaybekleyenchild)
        onaybekleyensection.expanded = true
        createdorders.addSection(onaybekleyensection)

        odemeturu.setRenderer(object : ExpandableLayout.Renderer<String, String> {
            override fun renderParent(view: View, model: String, isExpanded: Boolean, parentPosition: Int) {

                view.tvParent.setText(R.string.odemeturu)
                Picasso.with(context).load(R.mipmap.folder).into(view.imageView11)
                if(isExpanded)
                    Picasso.with(context).load(R.mipmap.uppicon).into(view.imageView12)
                else
                    Picasso.with(context).load(R.mipmap.righticon).into(view.imageView12)
            }

            override fun renderChild(view: View, model: String, parentPosition: Int, childPosition: Int) {

                val item1 = ProductItem("Nakit", "3 Katlı, Mayalandırma Odalı, Dijital Panel, Hava Klapesi, Sİyah Ön Görünüm, Davlumbaz.", "02.03.2018", R.mipmap.circle, R.mipmap.ic_launcher, R.mipmap.ic_launcher)
                val item2 = ProductItem("Kredi Kartı", "3 Katlı, Mayalandırma Odalı, Dijital Panel, Hava Klapesi, Sİyah Ön Görünüm, Davlumbaz.", "02.03.2018", R.mipmap.checked, R.mipmap.ic_launcher, R.mipmap.ic_launcher)
                onayladigimproductArray.clear()
                onayladigimproductArray.add(item1)
                onayladigimproductArray.add(item2)

                view.createdordersrec.addItemDecoration(DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL))
                onayladigimproductAdapter = PaidTypeRecyclerViewAdapter(onayladigimproductArray, requireContext())
                val gridLayoutManager = GridLayoutManager(requireContext(), 1)
                view.createdordersrec.layoutManager = gridLayoutManager
                view.createdordersrec.adapter = onayladigimproductAdapter

                ItemClickSupport.addTo(view.createdordersrec).setOnItemClickListener { recyclerView, position, v ->
                    addMainFragment(requireFragmentManager(),ProductDetail(), true, "ProductDetail")
                }


            }
        })

        odemeturu.setExpandListener(ExpandCollapseListener.ExpandListener<Any> { parentIndex, parent, view ->
            Picasso.with(context).load(R.mipmap.uppicon).into(view.imageView12)

        })

        odemeturu.setCollapseListener(ExpandCollapseListener.CollapseListener<Any> { parentIndex, parent, view ->
            Picasso.with(context).load(R.mipmap.righticon).into(view.imageView12)
        })

        val onayladigimsection = Section<String, String>()
        val onayladigimparent = ""
        val onayladigimchild = ""

        onayladigimsection.parent = onayladigimparent
        onayladigimsection.children.add(onayladigimchild)
        onayladigimsection.expanded = true
        odemeturu.addSection(onayladigimsection)


    }


}