package com.vw.juno.data.network.model

import com.google.gson.annotations.SerializedName


data class CountryResult(
        @SerializedName("iso_3166_1") val iso: String,
        @SerializedName("english_name") val englishName: String)