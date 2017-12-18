package com.emrekose.karchi.data

/**
 * Created by emrekose on 11.12.2017.
 */
class Resource<T> (val status: Status, val data: T, val message: String?) {
    companion object {
        fun <T> success(data: T) = Resource(Status.SUCCESS, data, null)
        fun <T> error(msg: String, data: T) = Resource(Status.ERROR, data, msg)
        fun <T> loading(data: T) = Resource(Status.LOADING, data, null)
    }
}