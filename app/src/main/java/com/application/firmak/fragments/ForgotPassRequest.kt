package com.application.firmak.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import com.application.firmak.FimakApp.Companion.addFragment
import com.application.firmak.activities.MainActivity
import com.application.firmak.R
import kotlinx.android.synthetic.main.fragment_forgotpassreq.*

//1
class ForgotPassRequest : Fragment() {

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    // Inflate the layout for this fragment


    return inflater.inflate(R.layout.fragment_forgotpassreq, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    btnSignIn.setOnClickListener(View.OnClickListener {
      val Email = loginEmail.text.toString()

      if (Email.isEmpty()) {
        inputEmail.error = requireActivity().resources.getString(R.string.emailbos)
        loginEmail.requestFocus()
        return@OnClickListener
      }

      val im = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
      im?.hideSoftInputFromWindow(loginEmail.windowToken, InputMethodManager.RESULT_UNCHANGED_SHOWN)
      if (true) {
        addFragment(requireFragmentManager(),ForgotPassConfirm(), true, "ForgotPassConfirm")
      }
    })

    kayit.setOnClickListener(View.OnClickListener {

      addFragment(requireFragmentManager(),Login(), true, "Login")

    })
  }

}