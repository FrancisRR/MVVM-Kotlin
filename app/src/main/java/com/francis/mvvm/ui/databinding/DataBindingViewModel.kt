package com.francis.mvvm.ui.databinding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.francis.mvvm.base.BaseViewModel
import com.francis.mvvm.utils.UiUtils

class DataBindingViewModel : BaseViewModel() {

    private val TAG = this::class.java.simpleName
    val liveData: LiveData<String>
        get() = mutableData

    var mutableData: MutableLiveData<String> = MutableLiveData()
    var normalString = "Hai"

    init {
    }


    public fun buttonClickAction() {
        UiUtils.errorLog(TAG, "triggered")
        normalString = (1..10).random().toString()
        mutableData.value = normalString
    }


}