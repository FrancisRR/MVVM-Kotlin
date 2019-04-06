package com.francis.mvvm.ui.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.francis.mvvm.R
import com.francis.mvvm.base.BaseActivity
import com.francis.mvvm.ui.databinding.DataBindingActivity
import com.francis.mvvm.ui.main.MainActivity

class HomeActivity : BaseActivity() {

    @BindView(R.id.btHome)
    lateinit var btHome: Button

    var homeViewModel: HomeViewModel? = null

    private val TAG = this::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        ButterKnife.bind(this)

        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)

        preference?.name = TAG



    }


    @OnClick(R.id.btDataBinding, R.id.btMain, R.id.btHome)
    public fun clickEvent(v: View) {
        when (v.id) {
            R.id.btDataBinding -> startActivity(Intent(this, DataBindingActivity::class.java))
            R.id.btMain -> startActivity(Intent(this, MainActivity::class.java))
            R.id.btHome -> homeCLick()
        }
    }


    private fun homeCLick() {
        btHome.setText(if (btHome.text == "Home") "HII" else "Home")
    }

}