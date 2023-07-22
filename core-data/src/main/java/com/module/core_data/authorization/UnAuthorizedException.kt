package com.module.core_data.authorization

class UnAuthorizedException(
    message : String? = null,
    cause : Throwable?= null
) : Exception(message,cause)