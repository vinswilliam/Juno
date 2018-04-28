package com.vw.juno.data.network.model

import com.google.gson.annotations.SerializedName
import com.vw.juno.util.IMG_PATH
import java.text.SimpleDateFormat
import java.util.*


data class MovieResult(
        @SerializedName("vote_count") val voteCount: Int,
        @SerializedName("id") val id: String,
        @SerializedName("video") val video: Boolean,
        @SerializedName("vote_average") val voteAverage: Float,
        @SerializedName("title") val title: String,
        @SerializedName("popularity") val popularity: Float,
        @SerializedName("poster_path") val posterPath: String,
        @SerializedName("original_language") val originalLanguage: String,
        @SerializedName("original_title") val originalTitle: String,
        @SerializedName("genre_ids") val genreIds: Array<String>,
        @SerializedName("backdrop_path") val backdropPath: String,
        @SerializedName("adult") val adult: Boolean,
        @SerializedName("overview") val overview: String,
        @SerializedName("release_date") val releaseDate: String
) {

    val posterPathImg: String
    get() { return IMG_PATH + posterPath }

    val releaseYearDate: String
        get() {
            val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)
            val calendar = Calendar.getInstance()
            calendar.time = sdf.parse(releaseDate)
            return calendar.get(Calendar.YEAR).toString()
        }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MovieResult

        if (voteCount != other.voteCount) return false
        if (id != other.id) return false
        if (video != other.video) return false
        if (voteAverage != other.voteAverage) return false
        if (title != other.title) return false
        if (popularity != other.popularity) return false
        if (posterPath != other.posterPath) return false
        if (originalLanguage != other.originalLanguage) return false
        if (originalTitle != other.originalTitle) return false
        if (!Arrays.equals(genreIds, other.genreIds)) return false
        if (backdropPath != other.backdropPath) return false
        if (adult != other.adult) return false
        if (overview != other.overview) return false
        if (releaseDate != other.releaseDate) return false

        return true
    }

    override fun hashCode(): Int {
        var result = voteCount
        result = 31 * result + id.hashCode()
        result = 31 * result + video.hashCode()
        result = 31 * result + voteAverage.hashCode()
        result = 31 * result + title.hashCode()
        result = 31 * result + popularity.hashCode()
        result = 31 * result + posterPath.hashCode()
        result = 31 * result + originalLanguage.hashCode()
        result = 31 * result + originalTitle.hashCode()
        result = 31 * result + Arrays.hashCode(genreIds)
        result = 31 * result + backdropPath.hashCode()
        result = 31 * result + adult.hashCode()
        result = 31 * result + overview.hashCode()
        result = 31 * result + releaseDate.hashCode()
        return result
    }
}