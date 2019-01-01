package com.application.firmak

import android.content.Context
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
import android.view.inputmethod.InputMethodManager
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import com.application.firmak.adapters.DocsRecyclerViewAdapter
import com.application.firmak.adapters.MenuRecyclerViewAdapter
import com.application.firmak.models.ProductItem
import kotlinx.android.synthetic.main.profilenewpass.*

class ProfileNewPass: Fragment() {

    private var productArray: ArrayList<ProductItem> = ArrayList<ProductItem>()
    private var productAdapter: DocsRecyclerViewAdapter? = null
    private var profileStrings : ArrayList<String> = ArrayList<String>();
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.profilenewpass, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        btnSignIn.setOnClickListener(View.OnClickListener {

            val oldPassword = oldloginPass.text.toString()
            val newPassword = loginPass.text.toString()
            val confirmPassword = loginPassConfirm.text.toString()

            if (oldPassword.isEmpty()) {
                oldinputPass.error = requireActivity().resources.getString(R.string.sifrebos)
                oldloginPass.requestFocus()
                return@OnClickListener
            }


            if (newPassword.isEmpty()) {
                inputPass.error = requireActivity().resources.getString(R.string.newsifrebos)
                loginPass.requestFocus()
                return@OnClickListener
            }

            if (confirmPassword.isEmpty()) {
                inputPassConfirm.error = requireActivity().resources.getString(R.string.newsifrebos)
                loginPassConfirm.requestFocus()
                return@OnClickListener
            }


            val im = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
            im?.hideSoftInputFromWindow(loginPass.windowToken, InputMethodManager.RESULT_UNCHANGED_SHOWN)
            if (true) {

            }
        })
    }


}