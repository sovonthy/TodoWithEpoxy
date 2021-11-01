package com.example.epoxy.data.local

import android.content.Context
import android.content.SharedPreferences
import com.example.epoxy.utils.Constant

class SharedPreferenceHelper {
    companion object {

        private var prefs: SharedPreferences? = null
        private var prefsHelper: SharedPreferenceHelper? = null

        @Synchronized
        fun getInstance(context: Context): SharedPreferenceHelper {
            if (prefsHelper == null) {
                prefsHelper = SharedPreferenceHelper()
                prefs = context.getSharedPreferences("pandaGoPref", 0)
            }
            return prefsHelper!!
        }
    }

    fun setCardClicked(value: String) {
        prefs!!.edit().putString(Constant.Card.IS_CLICKED, value).apply()
    }

    fun getCardClicked() = prefs?.getString(Constant.Card.IS_CLICKED, "")
}