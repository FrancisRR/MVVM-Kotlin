package com.francis.mvvm.ui.databinding

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.francis.mvvm.R
import com.francis.mvvm.base.BaseActivity
import com.francis.mvvm.databinding.ActivityDataBindingBinding

class DataBindingActivity : BaseActivity() {
    private val TAG = this::class.java.simpleName
    private var viewModel: DataBindingViewModel? = null
    private var binder: ActivityDataBindingBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUi()
    }

    private fun setUi() {
        setInstance()
    }

    private fun setInstance() {
        viewModel = ViewModelProviders.of(this).get(DataBindingViewModel::class.java)
        binder = DataBindingUtil.setContentView(this, R.layout.activity_data_binding)
        binder?.lifecycleOwner=this
        binder?.viewmodel = viewModel
    }
}