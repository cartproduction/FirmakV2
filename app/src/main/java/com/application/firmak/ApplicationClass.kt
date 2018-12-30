package com.application.firmak

import android.content.Context
import android.content.Intent
import android.content.pm.ResolveInfo
import android.location.Location
import android.support.v4.app.Fragment
import android.util.Log


import com.application.firmak.models.Sbit

import org.json.JSONArray
import org.json.JSONException

import java.io.IOException
import java.io.InputStream
import java.util.ArrayList

/**
 * Created by civil on 03/07/15.
 */
object ApplicationClass {

    private val SEARCH_COUNT = 20
    private val MAXID: Long = 0
    var width: Int = 0
    var height: Int = 0

    fun initShareIntent(type: String, ctx: Context) {
        var found = false
        val share = Intent(android.content.Intent.ACTION_SEND)
        share.type = "text/plain"

        // gets the list of intents that can be loaded.
        val resInfo = ctx.packageManager.queryIntentActivities(share, 0)
        if (!resInfo.isEmpty()) {
            for (info in resInfo) {
                if (info.activityInfo.packageName.toLowerCase().contains(type) || info.activityInfo.name.toLowerCase().contains(type)) {
                    share.putExtra(Intent.EXTRA_SUBJECT, ctx.resources.getString(R.string.app_name))
                    share.putExtra(Intent.EXTRA_TEXT, ctx.resources.getString(R.string.app_name) + "https://play.google.com/store/apps/details?id=com.civil.platform")
                    share.`package` = info.activityInfo.packageName
                    found = true
                    break
                }
            }
            if (!found)
                return

            ctx.startActivity(Intent.createChooser(share, "Select"))
        }
    }




}
