package com.application.firmak.activities

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.res.ResourcesCompat
import android.support.v4.graphics.drawable.DrawableCompat
import android.support.v7.app.ActionBar
import android.support.v7.widget.Toolbar
import android.view.*
import com.application.firmak.*
import com.application.firmak.FimakApp.Companion.addMainFragment
import com.application.firmak.Menu
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar_layout.*

class MainActivity : AppCompatActivity() {
//3.1.1 studio
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initToolbar()
        initBottomNavigation()

    }

    private fun initBottomNavigation() {
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView)

        bottomNavigationView.selectedItemId = R.id.menu_item1

        BottomNavigationViewHelper.addBadge(bottomNavigationView, this, 3)
        BottomNavigationViewHelper.sizeIcon(bottomNavigationView, getResources().getDisplayMetrics(), 50f)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            var selectedFragment: Fragment? = null
            if (bottomNavigationView.selectedItemId != item.itemId) {
                when (item.itemId) {
                    R.id.menu_item1 -> {
                        selectedFragment = Products()
                        apptitle_text.setText(R.string.urunlertitle)
                    }
                    R.id.menu_item2 -> {
                        selectedFragment = Orders()
                        apptitle_text.setText(R.string.siparistitle)
                    }
                    R.id.menu_item3 -> {
                        selectedFragment = Offers()
                        apptitle_text.setText(R.string.tekliftitle)
                    }
                    R.id.menu_item4 -> {
                        selectedFragment = Fragment4()
                        BottomNavigationViewHelper.removeBadge(bottomNavigationView, this, 3)
                        apptitle_text.setText(R.string.mesajtitle)
                    }
                    R.id.menu_item5 -> {
                        selectedFragment = Menu()
                        apptitle_text.setText(R.string.menutitle)
                    }
                }
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.framelayout, selectedFragment)
                transaction.commit()
            }
            true


        }

        addMainFragment(supportFragmentManager,Products(), false, "Products")
    }

    override fun onCreateOptionsMenu(menu: android.view.Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.mainmenu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return (when(item.itemId) {
            R.id.addbutton -> {
                true
            }
            else ->
                super.onOptionsItemSelected(item)
        })
    }

    private fun initToolbar() {
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        //CUSTOME ACTIONBAR
        // Specify that tabs should be displayed in the action bar.
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayShowTitleEnabled(false)
        val mInflater = LayoutInflater.from(this)
        val mCustomView = mInflater.inflate(R.layout.toolbar_layout, null)
        val params = ActionBar.LayoutParams(//Center the textview in the ActionBar !
                ActionBar.LayoutParams.WRAP_CONTENT,
                ActionBar.LayoutParams.MATCH_PARENT,
                Gravity.CENTER)



        actionBar.setCustomView(mCustomView, params)
        actionBar.setDisplayShowCustomEnabled(true)

        actionBar.setStackedBackgroundDrawable(ColorDrawable(Color.WHITE))

        actionBar.setBackgroundDrawable(ColorDrawable(Color.WHITE))

        getSupportActionBar()!!.setDisplayHomeAsUpEnabled(false)

        var drawable = ResourcesCompat.getDrawable(resources, R.mipmap.back, null)
        drawable = DrawableCompat.wrap(drawable!!)
        toolbar.navigationIcon = drawable

        apptitle_text.setText(R.string.urunlertitle)
    }


}

