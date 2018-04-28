package com.vw.juno.data.network.model

import com.google.gson.annotations.SerializedName
import java.util.*


data class ConfigurationResult(
        @SerializedName("images") val images: ImageResult,
        @SerializedName("change_keys") val changeKeys: Array<String>) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ConfigurationResult

        if (images != other.images) return false
        if (!Arrays.equals(changeKeys, other.changeKeys)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = images.hashCode()
        result = 31 * result + Arrays.hashCode(changeKeys)
        return result
    }
}

