package com.example.model

import com.google.gson.annotations.SerializedName

data class Resource<out T>(@SerializedName("status")
                           val status: Int,@SerializedName("data") val data: T?,@SerializedName("message") val message: String?) : java.io.Serializable{

    companion object {

        fun <T> success(data: T?, message: String?= ""): Resource<T> {
            return Resource(200, data, message)
        }

        fun <T> create(status: Int,data: T?, message: String?= ""): Resource<T> {
            return Resource(status, data, message)
        }

        fun <T> error(msg: String?, data: T? = null): Resource<T> {
            return Resource(400, data, msg)
        }

    }
}