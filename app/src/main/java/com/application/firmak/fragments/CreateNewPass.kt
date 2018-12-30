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
import kotlinx.android.synthetic.main.fragment_createnewpass.*

//1
class CreateNewPass : Fragment() {

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    // Inflate the layout for this fragment


    return inflater.inflate(R.layout.fragment_createnewpass, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    btnSignIn.setOnClickListener(View.OnClickListener {
      val newPassword = loginPass.text.toString()
      val confirmPassword = loginPassConfirm.text.toString()

      if (newPassword.isEmpty()) {
        inputPass.error = requireActivity().resources.getString(R.string.sifrebos)
        loginPass.requestFocus()
        return@OnClickListener
      }

      if (confirmPassword.isEmpty()) {
        inputPassConfirm.error = requireActivity().resources.getString(R.string.sifrebos)
        loginPassConfirm.requestFocus()
        return@OnClickListener
      }


      val im = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
      im?.hideSoftInputFromWindow(loginPass.windowToken, InputMethodManager.RESULT_UNCHANGED_SHOWN)
      if (true) {
        val i = Intent(requireActivity().getBaseContext(), MainActivity::class.java)
        requireActivity().startActivity(i)
        requireActivity().finish()
      }
    })

    kayit.setOnClickListener(View.OnClickListener {

      val i = Intent(requireContext(), MainActivity::class.java)
      requireActivity().startActivity(i)
      requireActivity().finish()

    })
  }

}