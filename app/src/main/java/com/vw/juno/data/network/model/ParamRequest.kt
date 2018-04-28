package com.vw.juno.data.network.model


data class ParamRequest(var page: Int = 1) {
    fun reset() {
        page = 1
    }
}