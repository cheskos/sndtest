package com.evite.giphytest

import retrofit2.Response
import java.io.IOException

fun <T> Response<T>.populateThrowable(): Throwable {
    var errorBodyString: String? = null
    try {
        val errorBody = this.errorBody()
        if (errorBody != null) {
            errorBodyString = errorBody.string()
        }
    } catch (e: IOException) {
        e.printStackTrace()
    }

    return Throwable(String.format("%s\n%s", this.message(), errorBodyString))
}