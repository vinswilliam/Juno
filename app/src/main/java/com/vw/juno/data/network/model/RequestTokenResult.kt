package com.vw.juno.data.network.model

import com.google.gson.annotations.SerializedName


data class RequestTokenResult(
        @SerializedName("success") val success: Boolean,
        @SerializedName("expires_at") val expiresAt: String,
        @SerializedName("request_token") val requestToken: String)