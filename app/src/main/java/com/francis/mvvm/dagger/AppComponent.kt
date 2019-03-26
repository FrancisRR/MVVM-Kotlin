package com.francis.mvvm.dagger

import com.francis.mvvm.app.AppPreference
import com.francis.mvvm.app.Repo
import com.francis.mvvm.base.BaseActivity
import com.francis.mvvm.base.BaseViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(baseActivity: BaseActivity)
    fun inject(baseViewModel: BaseViewModel)
    fun inject(repo: Repo)
    fun inject(preference: AppPreference)
}