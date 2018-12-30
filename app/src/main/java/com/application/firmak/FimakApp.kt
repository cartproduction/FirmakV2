package com.application.firmak

import android.app.Application
import android.location.Location
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import com.application.firmak.models.Sbit
import java.util.ArrayList

class FimakApp : Application() {

    companion object {

        val applicationID = "30"
        var TOKEN: String? = null
        val BASE_URL = "http://iotv2api.argede.com.tr"
        val LOGINTEST = "Mobil/LoginTest?"
        val LOGIN = "Mobil/Login"
        val SAVE_RANDEVU = "Mobil/SaveRandevu"
        val SAVE_KAM = "Mobil/PostKampanyaBasvuru"
        val POST = "Mobil/PostBildirimGeriDonus"
        val NOTIFICATION = "Mobil/GetBildirim"
        val NOTIFICATIONS = "Mobil/ListBildirim"
        val CONFIGURATIONS = "Mobil/GetKonfigurasyon"
        val CONSTANTS = "Mobil/GetSabit"
        val DATE = "Mobil/GetRandevu"
        val DATES = "Mobil/ListRandevu"
        val CAMPAIGNS = "Mobil/ListKampanya"
        val CAMPAIGN = "Mobil/GetKampanyaDetay"
        val KONUM = "Mobil/ListKonumGecmis"
        val CAR = "Mobil/GetArac"
        val PROFILE = "Mobil/GetKullaniciProfil"
        val SYMBOLS = "Mobil/ListSembol"
        val TELEPHONES = "Mobil/ListTelefonNumara"
        val COMMAND = "Mobil/PostKomut"
        val SEARCH_QUERY_TWEETS = "saumobil"
        val SEARCH_QUERY_FAVS = "saumobil"
        val SEARCH_RESULT_TYPE = "recent"
        var loct: Location? = null
        var IS_IT_FIRST_TIME = "is_it_first_time_pref"
        /*public static List<Kampanya> campaings = new ArrayList<Kampanya>();
        public static Data arac = new Data();
        public static Profil profil = new Profil();
        public static List<Tel> telephones = new ArrayList<Tel>();
        public static List<Bildirim> notis = new ArrayList<Bildirim>();
        public static List<Konum> locations = new ArrayList<Konum>();
        public static List<Sem> symbols = new ArrayList<Sem>();
        public static List<Rand> rdates = new ArrayList<Rand>();*/
        var sabt: List<Sbit> = object : ArrayList<Sbit>() {
            init {
                add(Sbit("deneme", "deneme", "deneme"))
                add(Sbit("deneme", "deneme", "deneme"))
                add(Sbit("deneme", "deneme", "deneme"))
                add(Sbit("deneme", "deneme", "deneme"))
            }
        }
        var baslik: List<Sbit> = object : ArrayList<Sbit>() {
            init {
                add(Sbit("deneme", "deneme", "deneme"))
                add(Sbit("deneme", "deneme", "deneme"))
                add(Sbit("deneme", "deneme", "deneme"))
                add(Sbit("deneme", "deneme", "deneme"))
            }
        }
        var aciklama: List<Sbit> = object : ArrayList<Sbit>() {
            init {
                add(Sbit("deneme", "deneme", "deneme"))
                add(Sbit("deneme", "deneme", "deneme"))
                add(Sbit("deneme", "deneme", "deneme"))
                add(Sbit("deneme", "deneme", "deneme"))
            }
        }


        fun addFragment(fragmentManager: FragmentManager, fragment: Fragment, addToBackStack: Boolean, tag: String) {
            val manager = fragmentManager
            val ft = manager.beginTransaction()

            if (addToBackStack) {
                ft.addToBackStack(tag)
            }
            ft.replace(R.id.rootView, fragment, tag)
            ft.commitAllowingStateLoss()
        }
    }

}