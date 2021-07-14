package com.xueqiya.example.data

/**
 * A generic class that holds a value with its loading status.
 * @param <T>
 */
sealed class Response<out T : Any> {
    data class Success<out T : Any>(val data: T) : Response<T>()
    data class Error(val exception: Exception) : Response<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
        }
    }
}