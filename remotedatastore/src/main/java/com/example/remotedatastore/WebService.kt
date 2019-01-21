package com.example.remotedatastore

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

inline fun <reified T> api(retrofit: Retrofit): T = retrofit.create(T::class.java)

abstract class WebService<out I, in P : WebServiceParams> {

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(url())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    //abstract fun api(): I

    abstract fun url(): String

    /**
     * Not mandatory to specify params.
     */
    open fun params(webServiceParams: P? = null): MutableMap<String, String> = WebServiceParams().map

}