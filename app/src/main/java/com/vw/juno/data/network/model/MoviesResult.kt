package com.vw.juno.data.network.model

import java.util.*


data class MoviesResult(val results: Array<MovieResult>) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MoviesResult

        if (!Arrays.equals(results, other.results)) return false

        return true
    }

    override fun hashCode(): Int {
        return Arrays.hashCode(results)
    }
}