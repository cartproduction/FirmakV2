package com.application.firmak.activities

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Point
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.text.method.ScrollingMovementMethod
import android.view.Display
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView

import com.application.firmak.ApplicationClass
import com.application.firmak.CirclePageIndicator
import com.application.firmak.R
import com.appus.splash.Splash
import kotlinx.android.synthetic.main.activity_splash.*
import kotlinx.android.synthetic.main.viewpager_item.*


class SplashActivity : AppCompatActivity() {
    private var isSliderAnimation = false
    lateinit var titleView: TextView
    lateinit var hintView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val window = window
        window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        val wm = getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = wm.defaultDisplay
        val size = Point()
        display.getSize(size)
        ApplicationClass.width = size.x
        ApplicationClass.height = size.y
        val drawable = resources.getDrawable(R.drawable.fimaklogoweb)
        val bitmap = (drawable as BitmapDrawable).bitmap
        val newDrawable = BitmapDrawable(resources, Bitmap.createScaledBitmap(bitmap, ApplicationClass.width / 2, ApplicationClass.width / 2, true))

        val splash = Splash.Builder(this, supportActionBar)
        splash.setBackgroundColor(resources.getColor(R.color.white))
        splash.setSplashImageColor(resources.getColor(R.color.colorAccent))
        splash.setSplashImage(newDrawable)
        splash.perform()

        titleView.text = resources.obtainTypedArray(R.array.titles).getString(0)
        hintView.text = resources.obtainTypedArray(R.array.hints).getString(0)

        hintView.movementMethod = ScrollingMovementMethod()
        login!!.setOnClickListener {
            val myIntent = Intent(this@SplashActivity, InterActivity::class.java)
            startActivity(myIntent)
            finish()
        }

        pager.adapter = ViewPagerAdapter(R.array.icons)

        pager.setPageTransformer(true, CustomPageTransformer())

        val lp = pager.layoutParams as ViewGroup.LayoutParams
        lp.height = ApplicationClass.height / 3 * 2 - 100
        pager.layoutParams = lp

        pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {

                titleView.text = resources.obtainTypedArray(R.array.titles).getString(position)
                hintView.text = resources.obtainTypedArray(R.array.hints).getString(position)
                if (position == 2)
                    login!!.visibility = View.VISIBLE
                else
                    login!!.visibility = View.GONE
            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })

        indicator.setViewPager(pager)


    }

    inner class ViewPagerAdapter(private val iconResId: Int) : PagerAdapter() {

        override fun getCount(): Int {
            return resources.getIntArray(iconResId).size
        }

        override fun isViewFromObject(view: View, `object`: Any): Boolean {
            return view === `object`
        }

        override fun instantiateItem(container: ViewGroup, position: Int): Any {

            val icon = resources.obtainTypedArray(iconResId).getDrawable(position)

            val itemView = layoutInflater.inflate(R.layout.viewpager_item, container, false)

            val lp = landing_img_slide.layoutParams as ViewGroup.LayoutParams
            lp.height = ApplicationClass.height / 3 * 2 - 100
            landing_img_slide.layoutParams = lp

            landing_img_slide.setImageDrawable(icon)

            container.addView(itemView)

            return itemView
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            container.removeView(`object` as RelativeLayout)

        }
    }

    inner class CustomPageTransformer : ViewPager.PageTransformer {


        override fun transformPage(view: View, position: Float) {
            val pageWidth = view.width

            val imageView = view.findViewById<View>(R.id.landing_img_slide)
            val contentView = view.findViewById<View>(R.id.landing_txt_hint)
            val txt_title = view.findViewById<View>(R.id.landing_txt_title)
            if (position < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left
            } else if (position <= 0) { // [-1,0]
                // This page is moving out to the left

                // Counteract the default swipe
                setTranslationX(view, pageWidth * -position)
                if (contentView != null) {
                    // But swipe the contentView
                    setTranslationX(contentView, pageWidth * position)
                    setTranslationX(txt_title, pageWidth * position)

                    setAlpha(contentView, 1 + position)
                    setAlpha(txt_title, 1 + position)
                }

                if (imageView != null) {
                    // Fade the image in
                    setAlpha(imageView, 1 + position)
                }

            } else if (position <= 1) { // (0,1]
                // This page is moving in from the right

                // Counteract the default swipe
                setTranslationX(view, pageWidth * -position)
                if (contentView != null) {
                    // But swipe the contentView
                    setTranslationX(contentView, pageWidth * position)
                    setTranslationX(txt_title, pageWidth * position)

                    setAlpha(contentView, 1 - position)
                    setAlpha(txt_title, 1 - position)

                }
                if (imageView != null) {
                    // Fade the image out
                    setAlpha(imageView, 1 - position)
                }

            }
        }
    }

    /**
     * Sets the alpha for the view. The alpha will be applied only if the running android device OS is greater than honeycomb.
     * @param view - view to which alpha to be applied.
     * @param alpha - alpha value.
     */
    private fun setAlpha(view: View, alpha: Float) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB && !isSliderAnimation) {
            view.alpha = alpha
        }
    }

    /**
     * Sets the translationX for the view. The translation value will be applied only if the running android device OS is greater than honeycomb.
     * @param view - view to which alpha to be applied.
     * @param translationX - translationX value.
     */
    private fun setTranslationX(view: View, translationX: Float) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB && !isSliderAnimation) {
            view.translationX = translationX
        }
    }

    public override fun onSaveInstanceState(outstate: Bundle?) {

        outstate?.putBoolean(SAVING_STATE_SLIDER_ANIMATION, isSliderAnimation)

        super.onSaveInstanceState(outstate)
    }

    public override fun onRestoreInstanceState(inState: Bundle?) {

        if (inState != null) {
            isSliderAnimation = inState.getBoolean(SAVING_STATE_SLIDER_ANIMATION, false)
        }
        super.onRestoreInstanceState(inState)

    }

    companion object {
        //public List<Sbit> sabt = new ArrayList<Sbit>();
        private val SAVING_STATE_SLIDER_ANIMATION = "SliderAnimationSavingState"
    }
}