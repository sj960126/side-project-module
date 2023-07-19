package com.module.core_data.retrofit.okhttp

import com.module.core_data.retrofit.interceptor.CoreLogInterceptor
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

/**
 * @author songhyeonsu
 * Created 2023/07/19 at 4:50 PM
 */
class DefaultOkHttpClient : CoreOkHttpsClient{

    companion object{
        private const val TIMEOUT_READ: Long = 15L
        private const val TIMEOUT_CONNECT: Long = 15L
        private const val TIMEOUT_WRITE: Long = 15L
    }

    override fun getOkHttpClientBuilder(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(TIMEOUT_READ, TimeUnit.SECONDS)
            .connectTimeout(TIMEOUT_CONNECT, TimeUnit.SECONDS)
            .writeTimeout(TIMEOUT_WRITE, TimeUnit.SECONDS)
            .also { clientBuilder ->
                clientBuilder.interceptors().clear()
                clientBuilder.addInterceptor(CoreLogInterceptor())
            }.build()
    }

}