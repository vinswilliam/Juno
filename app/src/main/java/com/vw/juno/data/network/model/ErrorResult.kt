package com.vw.juno.data.network.model

import com.google.gson.annotations.SerializedName


data class ErrorResult(@SerializedName("status_message") val statusMsg: String,
                       @SerializedName("status_code") val statusCode: Int)