package com.francis.mvvm.ui.databinding

import androidx.lifecycle.MutableLiveData
import com.francis.mvvm.base.BaseViewModel

class DataBindingViewModel : BaseViewModel() {

    private val TAG = this::class.java.simpleName
    private var data: MutableLiveData<Int>? = null
    private lateinit var data1: String

    init {
        data = MutableLiveData()
    }


    public fun buttonClickAction() {
        data1 = (1..10).random().toString()
        data?.value = (1..10).random()
    }


}