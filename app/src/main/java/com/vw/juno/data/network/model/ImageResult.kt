package com.vw.juno.data.network.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class ImageResult (
        @SerializedName("base_url") val baseUrl: String,
        @SerializedName("secure_base_url") val secureBaseUrl: String,
        @SerializedName("backdrop_sizes") val backdropSize: Array<String>,
        @SerializedName("logo_sizes") val logoSizes: Array<String>,
        @SerializedName("poster_sizes") val posterSizes: Array<String>,
        @SerializedName("profile_sizes") val profileSizes: Array<String>,
        @SerializedName("still_sizes") val stillSizes: Array<String>) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ImageResult

        if (baseUrl != other.baseUrl) return false
        if (secureBaseUrl != other.secureBaseUrl) return false
        if (!Arrays.equals(backdropSize, other.backdropSize)) return false
        if (!Arrays.equals(logoSizes, other.logoSizes)) return false
        if (!Arrays.equals(posterSizes, other.posterSizes)) return false
        if (!Arrays.equals(profileSizes, other.profileSizes)) return false
        if (!Arrays.equals(stillSizes, other.stillSizes)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = baseUrl.hashCode()
        result = 31 * result + secureBaseUrl.hashCode()
        result = 31 * result + Arrays.hashCode(backdropSize)
        result = 31 * result + Arrays.hashCode(logoSizes)
        result = 31 * result + Arrays.hashCode(posterSizes)
        result = 31 * result + Arrays.hashCode(profileSizes)
        result = 31 * result + Arrays.hashCode(stillSizes)
        return result
    }
}