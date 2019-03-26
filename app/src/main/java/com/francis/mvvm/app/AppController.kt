package com.francis.mvvm.app

import android.app.Application
import com.francis.mvvm.dagger.AppComponent
import com.francis.mvvm.dagger.AppModule
import com.francis.mvvm.dagger.DaggerAppComponent

class AppController : Application() {


    override fun onCreate() {
        super.onCreate()
        Injector = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }

    companion object {
        lateinit var instance: AppController
        internal lateinit var Injector: AppComponent

    }


}


