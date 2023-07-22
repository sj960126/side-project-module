package com.module.core_data.retrofit.interceptor

import com.module.core_data.authorization.ITokenManager
import com.module.core_data.retrofit.model.HeaderDataModel
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class CoreTokenInterceptor @Inject constructor(
    private val tokenManager : ITokenManager,
    private val headerDataModel: HeaderDataModel
) : Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        val originRequest = chain.request()
        val requestWithTokenBuilder = originRequest.newBuilder()
            .addHeader(tokenManager.getHeaderTid(), headerDataModel.tid)
            .addHeader(tokenManager.getHeaderDevice(), headerDataModel.device)
            .addHeader(tokenManager.getHeaderModel(), headerDataModel.headerModel)
            .addHeader(tokenManager.getHeaderAppVersion(),headerDataModel.appVersion)

        tokenManager.getAccessToken()?.let { token ->
            requestWithTokenBuilder.addHeader(
                tokenManager.getHeaderName(),
                tokenManager.getHeaderValueFormat().format(token)
            )
        }

        return chain.proceed(request = requestWithTokenBuilder.build())
    }

}