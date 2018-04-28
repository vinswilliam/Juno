package com.vw.juno.data.network.model

import com.google.gson.annotations.SerializedName
import com.vw.juno.util.IMG_PATH
import java.text.SimpleDateFormat
import java.util.*

data class MovieDetailResult(
        @SerializedName("adult") val adult: Boolean,
        @SerializedName("backdrop_path") val backdropPath: String,
        @SerializedName("budget") val budget: Long,
        @SerializedName("genres") val genres: Array<GenreResult>,
        @SerializedName("homepage") val homepage: String,
        @SerializedName("id") val id: String,
        @SerializedName("imdb_id") val imdbId: String,
        @SerializedName("original_language") val originalLanguage: String,
        @SerializedName("original_title") val originalTitle: String,
        @SerializedName("overview") val overview: String,
        @SerializedName("popularity") val popularity: Float,
        @SerializedName("poster_path") val posterPath: String?,
        @SerializedName("production_companies") val productionCompanies: Array<ProductionCompaniesResult>,
        @SerializedName("production_countries") val productionCountriesResult: Array<ProductionCountriesResult>,
        @SerializedName("release_date") val releaseDate: String,
        @SerializedName("revenue") val revenue: Long,
        @SerializedName("runtime") val runtime: Int,
        @SerializedName("spoken_languages") val spokenLanguageResult: Array<SpokenLanguageResult>,
        @SerializedName("status") val status: String,
        @SerializedName("tagline") val tagline: String,
        @SerializedName("title") val title: String,
        @SerializedName("video") val video: Boolean,
        @SerializedName("vote_average") val voteAverage: Float,
        @SerializedName("vote_count") val voteCount: Int
) {

    val backdropPathImg: String
        get() = IMG_PATH + backdropPath

    val posterPathImg: String
        get() = IMG_PATH + posterPath

    val releaseYearDate: String
        get() {
            val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)
            val calendar = Calendar.getInstance()
                    calendar.time = sdf.parse(releaseDate)
            return calendar.get(Calendar.YEAR).toString()
        }

    val budgetString: String
    get() = String.format(Locale.ENGLISH, "%,d", budget)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MovieDetailResult

        if (adult != other.adult) return false
        if (backdropPath != other.backdropPath) return false
        if (budget != other.budget) return false
        if (!Arrays.equals(genres, other.genres)) return false
        if (homepage != other.homepage) return false
        if (id != other.id) return false
        if (imdbId != other.imdbId) return false
        if (originalLanguage != other.originalLanguage) return false
        if (originalTitle != other.originalTitle) return false
        if (overview != other.overview) return false
        if (popularity != other.popularity) return false
        if (posterPath != other.posterPath) return false
        if (!Arrays.equals(productionCompanies, other.productionCompanies)) return false
        if (!Arrays.equals(productionCountriesResult, other.productionCountriesResult)) return false
        if (releaseDate != other.releaseDate) return false
        if (revenue != other.revenue) return false
        if (runtime != other.runtime) return false
        if (!Arrays.equals(spokenLanguageResult, other.spokenLanguageResult)) return false
        if (status != other.status) return false
        if (tagline != other.tagline) return false
        if (title != other.title) return false
        if (video != other.video) return false
        if (voteAverage != other.voteAverage) return false
        if (voteCount != other.voteCount) return false

        return true
    }

    override fun hashCode(): Int {
        var result = adult.hashCode()
        result = 31 * result + backdropPath.hashCode()
        result = 31 * result + budget.hashCode()
        result = 31 * result + Arrays.hashCode(genres)
        result = 31 * result + homepage.hashCode()
        result = 31 * result + id.hashCode()
        result = 31 * result + imdbId.hashCode()
        result = 31 * result + originalLanguage.hashCode()
        result = 31 * result + originalTitle.hashCode()
        result = 31 * result + overview.hashCode()
        result = 31 * result + popularity.hashCode()
        result = 31 * result + (posterPath?.hashCode() ?: 0)
        result = 31 * result + Arrays.hashCode(productionCompanies)
        result = 31 * result + Arrays.hashCode(productionCountriesResult)
        result = 31 * result + releaseDate.hashCode()
        result = 31 * result + revenue.hashCode()
        result = 31 * result + runtime
        result = 31 * result + Arrays.hashCode(spokenLanguageResult)
        result = 31 * result + status.hashCode()
        result = 31 * result + tagline.hashCode()
        result = 31 * result + title.hashCode()
        result = 31 * result + video.hashCode()
        result = 31 * result + voteAverage.hashCode()
        result = 31 * result + voteCount
        return result
    }
}

data class GenreResult(
        @SerializedName("id") val id: Int,
        @SerializedName("name") val name: String
)

data class ProductionCompaniesResult(
        @SerializedName("id") val id: Int,
        @SerializedName("logo_path") val logoPath: String,
        @SerializedName("name") val name: String,
        @SerializedName("origin_country") val originCountry: String
)

data class ProductionCountriesResult(
        @SerializedName("iso_3166_1") val iso: String,
        @SerializedName("name") val name: String
)

data class SpokenLanguageResult(
        @SerializedName("iso_639_1") val iso: String,
        @SerializedName("name") val name: String
)
