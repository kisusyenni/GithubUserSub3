package com.kisusyenni.githubusersub3.data.source.remote.api

import com.kisusyenni.githubusersub3.data.source.remote.response.*
import retrofit2.Call
import retrofit2.http.*
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    fun getUsers(
    ): Call<List<UsersResponse>>

    @GET("users/{username}")
    fun getUserDetail(
        @Path("username") username: String
    ): Call<UserDetailResponse>

    @GET("users/{username}/followers")
    fun getUserFollowers(
        @Path("username") username: String
    ): Call<List<UserFollowersResponseItem>>

    @GET("users/{username}/following")
    fun getUserFollowing(
        @Path("username") username: String
    ): Call<List<UserFollowingResponseItem>>

    @GET("search/users")
    fun getSearchResult(
        @Query("q") username: String
    ): Call<UserSearchResponse>

}