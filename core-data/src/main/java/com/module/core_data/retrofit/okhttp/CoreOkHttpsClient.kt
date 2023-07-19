package com.module.core_data.retrofit.okhttp

import okhttp3.OkHttpClient

/**
 * @author songhyeonsu
 * Created 2023/07/19 at 4:55 PM
 */
interface CoreOkHttpsClient {

    fun getOkHttpClientBuilder(): OkHttpClient

}