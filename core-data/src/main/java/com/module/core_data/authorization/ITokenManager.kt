package com.module.core_data.authorization

interface ITokenManager {

    /** Header Key 값**/
    fun getHeaderName(): String

    /** Header TID 형식**/
    fun getHeaderTid(): String

    /** Header DEVICE 형식**/
    fun getHeaderDevice(): String

    /** Header MODEL 형식**/
    fun getHeaderModel(): String

    /** Header App Version 형식**/
    fun getHeaderAppVersion(): String

    /*** Header Value 형식**/
    fun getHeaderValueFormat(): String

    /** 저장 되어 있는 Access 토큰 정보 **/
    fun getAccessToken(): String?

    /** Access 토큰 정보 저장**/
    fun setAccessToken(token: String?)

    /** 저장 되어 있는 Refresh 토큰 정보 **/
    fun getRefreshToken(): String?

    /** Refresh 토큰 정보 저장**/
    fun setRefreshToken(token: String?)

    /** 저장 되어 있는 Fcm 토큰 정보**/
    fun getFcmToken(): String?

    /** Fcm 토큰 정보 저장**/
    fun setFcmToken(token: String)

    /** 저장 되어 있는 토큰 만료 처리**/
    fun clearToken()

    /** 토큰 유효성 검사**/
    fun isValidToken(): Boolean
}