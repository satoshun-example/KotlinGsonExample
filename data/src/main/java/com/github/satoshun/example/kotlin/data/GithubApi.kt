package com.github.satoshun.example.kotlin.data

import com.google.gson.annotations.SerializedName
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*


interface GithubApi {
  /**
   * q=language:java+created:>%Y-%m-%d
   */
  @GET("search/repositories?sort=stars&order=desc")
  fun trendings(@Query("q") query: String): Observable<GitHubTrendingEntity>
}

data class GitHubTrendingEntity(
    @SerializedName("items") val items: List<GitHubTrendingItem> = Collections.emptyList()
)

data class GitHubTrendingItem(
    @SerializedName("name") val name: String,
    @SerializedName("full_name") val fullName: String,
    @SerializedName("stargazers_count") val stargazersCount: Int,
    @SerializedName("html_url") val htmlUrl: String,
    @SerializedName("description") val description: String,
    @SerializedName("owner") val owner: Owner
)

data class Owner(
    @SerializedName("avatar_url") var avatarUrl: String,
    @SerializedName("login") var login: String
)
