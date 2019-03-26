package com.francis.mvvm.ui.main

import android.annotation.SuppressLint
import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.francis.mvvm.base.BaseViewModel
import com.francis.mvvm.data.response.postdetails.PostDetailsResponse
import com.francis.mvvm.utils.RxJavaUtils
import io.reactivex.Observable
import io.reactivex.functions.BiFunction

@SuppressLint("CheckResult")
class MainActivityViewModel() : BaseViewModel() {

    private var TAG = this::class.java.simpleName
    internal var postDetailsResponse: MutableLiveData<PostDetailsResponse>? = null
    private var context: Context? = null

    internal fun setContext(mainActivity: Context) {
        this.context = mainActivity

    }

    init {
        postDetailsResponse = MutableLiveData()

    }


    fun fetchApi() {
        repo?.postDetails()
            ?.compose(RxJavaUtils.applyObserverbleScheduler())
            ?.doOnSubscribe { showLoading(context, "") }
            ?.doOnTerminate { hideLoading() }
            ?.subscribe({ response ->
                postDetailsResponse?.value = response
                hideLoading()
            }, { thowable ->
                postDetailsResponse?.value = null
                hideLoading()
                exceptionHandling(thowable)
            })
    }


    fun fetchZipOperator() {
        Observable.zip(repo?.postDetails(), repo?.postDetails(),
            BiFunction { t1: PostDetailsResponse, t2: PostDetailsResponse ->  })
            .compose(RxJavaUtils.applyObserverbleScheduler())
            .subscribe({ res -> }, { thro -> })

    }


}