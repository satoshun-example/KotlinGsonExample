package com.github.satoshun.example.kotlin.data

import com.google.gson.annotations.SerializedName
import io.reactivex.Observable
import paperparcel.PaperParcel
import paperparcel.PaperParcelable
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

@PaperParcel data class GitHubTrendingEntity(
    @SerializedName("items") val items: List<GitHubTrendingItem> = Collections.emptyList()
) : PaperParcelable {
  companion object {
    @JvmField val CREATOR = PaperParcelGitHubTrendingEntity.CREATOR
  }
}

@PaperParcel data class GitHubTrendingItem(
    @SerializedName("name") val name: String,
    @SerializedName("full_name") val fullName: String,
    @SerializedName("stargazers_count") val stargazersCount: Int,
    @SerializedName("html_url") val htmlUrl: String,
    @SerializedName("description") val description: String,
    @SerializedName("owner") val owner: Owner
) : PaperParcelable {
  companion object {
    @JvmField val CREATOR = PaperParcelGitHubTrendingItem.CREATOR
  }
}

@PaperParcel data class Owner(
    @SerializedName("avatar_url") val avatarUrl: String,
    @SerializedName("login") val login: String
) : PaperParcelable {
  companion object {
    @JvmField val CREATOR = PaperParcelOwner.CREATOR
  }
}
