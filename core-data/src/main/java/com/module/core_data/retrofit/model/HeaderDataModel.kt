package com.module.core_data.retrofit.model

data class HeaderDataModel(
    val tid : String = (System.currentTimeMillis() / 1000L).toString(),
    val device : String = "Android",
    val headerModel : String,
    val appVersion : String
)
