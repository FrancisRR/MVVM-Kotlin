package com.francis.mvvm.app

import android.content.Context
import android.content.SharedPreferences
import com.francis.mvvm.utils.UiUtils
import javax.inject.Inject

class AppPreference(context: Context) {

    private val TAG = this::class.java.simpleName
    @set:Inject
    internal var sharedPreferences: SharedPreferences? = null


    init {
        AppController.Injector.inject(this)
    }


    private val NAME: String = "NAME_KEY"


    var name: String?
        get() {
            if (sharedPreferences == null) {
                UiUtils.errorLog(TAG, "shared preference is null")
            }else{
                UiUtils.errorLog(TAG, "shared preference is not null")
            }
            return sharedPreferences?.getString(NAME, "")
        }
        set(value) = sharedPreferences?.edit()?.putString(NAME, value)!!.apply()


}