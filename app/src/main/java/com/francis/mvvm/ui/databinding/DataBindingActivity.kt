package com.francis.mvvm.ui.databinding

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.francis.mvvm.base.BaseActivity

class DataBindingActivity : BaseActivity() {
    private val TAG = this::class.java.simpleName
    private var viewModel: DataBindingViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        DataBindingUtil.setContentView<com.francis.mvvm.databinding.ActivityDataBindingBinding>(this,R.layout.activity_data_binding)
        setUi()
    }

    private fun setUi() {
        setInstance()
    }

    private fun setInstance() {
        viewModel = ViewModelProviders.of(this).get(DataBindingViewModel::class.java)
    }
}