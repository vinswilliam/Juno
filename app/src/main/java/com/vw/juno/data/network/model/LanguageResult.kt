package com.vw.juno.data.network.model

import com.google.gson.annotations.SerializedName


data class LanguageResult(
        @SerializedName("iso_639_1") val iso: String,
        @SerializedName("english_name") val englishName: String,
        @SerializedName("name") val name: String
)