package com.vw.juno.data.network.model

import com.google.gson.annotations.SerializedName


data class SessionResult(val success: Boolean,
                         @SerializedName("session_id") val sessionId: String)