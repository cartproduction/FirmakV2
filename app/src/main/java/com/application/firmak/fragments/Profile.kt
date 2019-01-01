package com.application.firmak

import android.graphics.Color
import android.graphics.Typeface
import android.opengl.Visibility
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import com.application.firmak.adapters.DocsRecyclerViewAdapter
import com.application.firmak.adapters.MenuRecyclerViewAdapter
import com.application.firmak.models.ProductItem
import com.nineoldandroids.view.ViewHelper.setAlpha
import com.nineoldandroids.view.ViewHelper.setTranslationX
import kotlinx.android.synthetic.main.productdetail.*
import kotlinx.android.synthetic.main.profile.*
import kotlinx.android.synthetic.main.profilepager_item.view.*

class Profile: Fragment() {

    private var productArray: ArrayList<ProductItem> = ArrayList<ProductItem>()
    private var productAdapter: DocsRecyclerViewAdapter? = null
    private var profileStrings : ArrayList<String> = ArrayList<String>();
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initMenuRecycleView()

    }

    private fun initMenuRecycleView() {

        /*val lp2 = imageView.layoutParams as ViewGroup.LayoutParams
        lp2.height = ApplicationClass.height / 2
        lp2.width = ApplicationClass.width / 2
        imageView.layoutParams = lp2*/

        profileStrings.clear()
        profileStrings.add("Firma Ünvanı")
        profileStrings.add("Solvepark Teknoloji A.Ş.")
        profileStrings.add("Vergi Dairesi")
        profileStrings.add("Beşiktaş")
        profileStrings.add("Vergi Numarası")
        profileStrings.add("773 035 25 09")
        profileStrings.add("Fatura Adresi")
        profileStrings.add("Balmumcu Mh. Gazi Umur Paşa Sk. No:34 34349 Beşiktaş \n" +
                "İstanbul / Türkiye")
        profileStrings.add("Ünvanı")
        profileStrings.add("Solvepark Teknoloji A.Ş. Yönetim Kurulu Başkanı")
        profileStrings.add("Görevi")
        profileStrings.add("Yönetim Kurulu Başkanı")

        pager.adapter = ViewPagerAdapter(profileStrings)
        pager.setPageTransformer(true, CustomPageTransformer())
        indicator.setViewPager(pager)
        if(profileStrings.size>8) {
            indicator.visibility = View.VISIBLE
        }else
            indicator.visibility = View.INVISIBLE
    }

    inner class ViewPagerAdapter(private val info: ArrayList<String>) : PagerAdapter() {

        override fun getCount(): Int {

            if(info.size>8)
                return info.size/8+1
            else
                return 1
        }

        override fun isViewFromObject(view: View, `object`: Any): Boolean {
            return view === `object`
        }

        override fun instantiateItem(container: ViewGroup, position: Int): Any {

            val itemView = layoutInflater.inflate(R.layout.profilepager_item, container, false)

            for (i in 0..7) {
                if((position == 0 && i<info.size)||(position == 1 && (i+8)<info.size)) {
                    val textView = TextView(context)
                    textView.layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                    textView.gravity = Gravity.CENTER
                    textView.setTextColor(Color.BLACK)
                    if(position==0)
                        textView.setText(info.get(i))
                    if(position==1)
                        textView.setText(info.get(8+i))
                    if (i % 2 == 0)
                        textView.setTypeface(null, Typeface.BOLD);

                    val params = LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                    if(i==3 || i==5 || i==6 || i==8)
                        params.setMargins(8, 13, 8, 1)
                    else
                        params.setMargins(8, 1, 8, 1)
                    textView.setLayoutParams(params)

                    itemView.profileinfo.addView(textView)
                }else
                    break

            }
            container.addView(itemView)

            return itemView
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            container.removeView(`object` as LinearLayout)

        }
    }

    inner class CustomPageTransformer : ViewPager.PageTransformer {


        override fun transformPage(view: View, position: Float) {
            val pageWidth = view.width

            if (position < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left
            } else if (position <= 0) { // [-1,0]
                // This page is moving out to the left

                // Counteract the default swipe
                setTranslationX(view, pageWidth * -position)
                if (view.profileinfo != null) {
                    // But swipe the contentView
                    setTranslationX(view.profileinfo, pageWidth * position)

                    setAlpha(view.profileinfo, 1 + position)
                }

            } else if (position <= 1) { // (0,1]
                // This page is moving in from the right

                // Counteract the default swipe
                setTranslationX(view, pageWidth * -position)
                if (view.profileinfo != null) {
                    // But swipe the contentView
                    setTranslationX(view.profileinfo, pageWidth * position)

                    setAlpha(view.profileinfo, 1 - position)

                }

            }
        }
    }


}