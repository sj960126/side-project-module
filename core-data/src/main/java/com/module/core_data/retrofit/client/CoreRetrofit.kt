package com.module.core_data.retrofit.client

import com.module.core_data.retrofit.okhttp.DefaultOkHttpClient
import com.module.core_data.retrofit.okhttp.CoreOkHttpsClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @author songhyeonsu
 * Created 2023/07/19 at 4:45 PM
 */
class CoreRetrofit {

    fun<S> getRequestRetrofit(serviceClass: Class<S>,baseUrl : String, okHttpClient: CoreOkHttpsClient = DefaultOkHttpClient()): S =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient.getOkHttpClientBuilder())
            .baseUrl(baseUrl)
            .build()
            .create(serviceClass)

}