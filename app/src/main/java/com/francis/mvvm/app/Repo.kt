package com.francis.mvvm.app

import com.francis.mvvm.data.response.postdetails.PostDetailsResponse
import com.francis.mvvm.utils.RxJavaUtils
import io.reactivex.Observable
import javax.inject.Inject

class Repo(val repoApi: RepoApi) {

    @Inject
    lateinit var preference: AppPreference

    init {
        AppController.Injector.inject(this)
    }


    public fun postDetails(): Observable<PostDetailsResponse> {
        return repoApi.getPostDetails()
            .compose(RxJavaUtils.applyErrorTransformer())
            .map { it }
    }


}