package com.module.core_data.remote

import com.module.core_data.authorization.UnAuthorizedException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import timber.log.Timber

abstract class BaseRemoteDataSource {

    companion object {
        const val CODE_UNAUTHORIZED: Int = 401
        const val MESSAGE_UNAUTHORIZED: String = "UnknownException"
    }

    suspend inline fun <T> runWithHandlingResult(crossinline callAction: suspend () -> Response<T>): Result<T?> =
         try {
            withContext(Dispatchers.IO) {
                val response = callAction()

                withContext(Dispatchers.Main) {
                    when {
                        // statusCode 200..300
                        response.isSuccessful -> {
                            Result.success(response.body())
                        }
                        // unauthorized 401
                        response.code() == CODE_UNAUTHORIZED -> {
                            Result.failure(UnAuthorizedException())
                        }
                        else -> {
                            Result.failure(exception = Exception(Throwable(message = MESSAGE_UNAUTHORIZED)))
                        }
                    }
                }
            }
        } catch (e: Exception) {
            withContext(Dispatchers.Main) {
                Timber.e(e)
                Result.failure(e)
            }
        }

}