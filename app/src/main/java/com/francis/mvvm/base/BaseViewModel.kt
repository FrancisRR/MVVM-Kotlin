package com.francis.mvvm.base

import android.app.ProgressDialog
import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import com.francis.mvvm.app.AppController
import com.francis.mvvm.app.Repo
import com.francis.mvvm.utils.UiUtils
import javax.inject.Inject

abstract class BaseViewModel : ViewModel() {

    @set:Inject
    internal var repo: Repo? = null

    private var dialog: ProgressDialog? = null

    init {
        AppController.Injector.inject(this)
    }


    internal fun showLoading(context: Context?, msg: String) {
        if (dialog == null) {
            dialog = UiUtils.showLoadingDialog(context, "Loading")
            dialog?.show()
        } else {
            dialog?.show()
        }
    }

    internal fun hideLoading() {
        if (dialog != null) {
            dialog?.dismiss()
        }
    }

    internal fun exceptionHandling(throwable: Throwable?) {
        Log.e("Api Failed", throwable?.message);
    }

}
