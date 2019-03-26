package com.francis.mvvm.dagger

import android.content.Context
import com.francis.mvvm.app.ApiConstanct
import com.francis.mvvm.app.AppPreference
import com.francis.mvvm.app.Repo
import com.francis.mvvm.app.RepoApi
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.squareup.otto.Bus
import com.squareup.otto.ThreadEnforcer
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class AppModule(val context: Context) {

    @Singleton
    @Provides
    fun preference() = AppPreference(context)

    @Singleton
    @Provides
    fun sharedPreference() = context.getSharedPreferences("MY_DB", Context.MODE_PRIVATE)

    @Singleton
    @Provides
    fun getBus() = Bus(ThreadEnforcer.ANY)

    @Singleton
    @Provides
    fun getGson() = GsonBuilder().setLenient().serializeNulls().create()

    @Singleton
    @Provides
    fun getRepo() = createRepo()

    private fun createRepo(): Repo {
        val loginInterceptor = HttpLoggingInterceptor()
        loginInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
            .readTimeout(180, TimeUnit.SECONDS)
            .writeTimeout(180, TimeUnit.SECONDS)
            .connectTimeout(180, TimeUnit.SECONDS)
            .addInterceptor(loginInterceptor)
            .build()

        val retrofit = Retrofit.Builder().baseUrl(ApiConstanct.BASE_URL)
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(Gson())).build()

        return Repo(retrofit.create(RepoApi::class.java))


    }
}