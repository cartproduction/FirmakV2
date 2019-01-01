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
import com.application.firmak.adapters.DocsRecyclerViewAdapter
import com.application.firmak.adapters.OfferSummaryRecyclerViewAdapter
import com.application.firmak.adapters.OffersRecyclerViewAdapter
import com.application.firmak.adapters.OrdersRecyclerViewAdapter
import iammert.com.expandablelib.ExpandableLayout
import iammert.com.expandablelib.Section
import kotlinx.android.synthetic.main.urunlerim.*
import com.application.firmak.models.ProductItem
import com.squareup.picasso.Picasso
import iammert.com.expandablelib.ExpandCollapseListener
import kotlinx.android.synthetic.main.layout_child.view.*
import kotlinx.android.synthetic.main.layout_header.view.*
import kotlinx.android.synthetic.main.offerssummary.*
import kotlinx.android.synthetic.main.summary_child.view.*

class OffersSummary: Fragment() {

    private var productArray: ArrayList<ProductItem> = ArrayList<ProductItem>()
    private var productAdapter: DocsRecyclerViewAdapter? = null
    private var onayladigimproductArray: ArrayList<ProductItem> = ArrayList<ProductItem>()
    private var onayladigimproductAdapter: OfferSummaryRecyclerViewAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.offerssummary, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        initExpandableLayouts()
        initMenuRecycleView()
    }

    private fun initExpandableLayouts() {
        onaybekleyen.setRenderer(object : ExpandableLayout.Renderer<String, String> {
            override fun renderParent(view: View, model: String, isExpanded: Boolean, parentPosition: Int) {

                view.tvParent.setText(R.string.ozet)
                view.imageView11.visibility = View.INVISIBLE
                view.imageView12.visibility = View.INVISIBLE
                view.sample1.getSurfaceView().setOnClickListener(View.OnClickListener {

                    addMainFragment(requireFragmentManager(), PaymentPlan(), true, "PaymentPlan")
                })
            }

            override fun renderChild(view: View, model: String, parentPosition: Int, childPosition: Int) {


                view.textView4.setText(R.string.text)
                view.textView14.setText(R.string.ozet)
                view.dateoffers.setText(R.string.ozet)


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

                view.tvParent.setText(R.string.urunler)
            }

            override fun renderChild(view: View, model: String, parentPosition: Int, childPosition: Int) {

                val item1 = ProductItem("Estone 300", "3 Katlı, Mayalandırma Odalı, Dijital Panel, Hava Klapesi, Sİyah Ön Görünüm, Davlumbaz.", "02.03.2018", R.mipmap.estone, R.mipmap.ic_launcher, R.mipmap.ic_launcher)
                val item2 = ProductItem("Rokon", "3 Katlı, Mayalandırma Odalı, Dijital Panel, Hava Klapesi, Sİyah Ön Görünüm, Davlumbaz.", "02.03.2018", R.mipmap.rokon, R.mipmap.ic_launcher, R.mipmap.ic_launcher)
                onayladigimproductArray.clear()
                onayladigimproductArray.add(item1)
                onayladigimproductArray.add(item2)

                view.createdordersrec.addItemDecoration(DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL))
                onayladigimproductAdapter = OfferSummaryRecyclerViewAdapter(onayladigimproductArray, requireContext())
                val gridLayoutManager = GridLayoutManager(requireContext(), 1)
                view.createdordersrec.layoutManager = gridLayoutManager
                view.createdordersrec.adapter = onayladigimproductAdapter

                ItemClickSupport.addTo(view.createdordersrec).setOnItemClickListener { recyclerView, position, v ->
                    addMainFragment(requireFragmentManager(),ProductDetail(), true, "ProductDetail")
                }


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

    private fun initMenuRecycleView() {

        /*val lp2 = imageView.layoutParams as ViewGroup.LayoutParams
        lp2.height = ApplicationClass.height / 2
        lp2.width = ApplicationClass.width / 2
        imageView.layoutParams = lp2*/

        val item1 = ProductItem("Teknik Dökümanı", "", " ", R.mipmap.pdficon, R.mipmap.ic_launcher, R.mipmap.ic_launcher)
        val item2 = ProductItem("Extra Aksesuar Dökümanı", "", " ", R.mipmap.pdficon, R.mipmap.ic_launcher, R.mipmap.ic_launcher)
        val item3 = ProductItem("Montaj Bilgileri", "", " ", R.mipmap.pdficon, R.mipmap.ic_launcher, R.mipmap.ic_launcher)
        productArray.clear()
        productArray.add(item1)
        productArray.add(item2)
        productArray.add(item3)
        docs2!!.addItemDecoration(DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL))
        productAdapter = DocsRecyclerViewAdapter(productArray, requireContext())
        val gridLayoutManager = GridLayoutManager(requireContext(), 1)
        docs2!!.layoutManager = gridLayoutManager
        docs2!!.adapter = productAdapter

    }


}