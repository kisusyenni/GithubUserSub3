package com.kisusyenni.githubusersub3.data.source.remote

import android.util.Log
import com.kisusyenni.githubusersub3.data.source.remote.api.ApiConfig
import com.kisusyenni.githubusersub3.data.source.remote.response.UsersResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource {
    companion object {
        private const val TAG = "RemoteDataSourcce"
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource().apply { instance = this }
            }
    }

    fun getUsers(callback: LoadUsersCallback){
        val client = ApiConfig.getApiService().getUsers()
        client.enqueue(object : Callback<List<UsersResponse>> {
            override fun onResponse(
                call: Call<List<UsersResponse>>,
                response: Response<List<UsersResponse>>
            ) {
                val data = response.body()
                callback.onUsersLoaded(response.body())
            }
            override fun onFailure(call: Call<List<UsersResponse>>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })
    }

    interface LoadUsersCallback {
        fun onUsersLoaded(users : List<UsersResponse>?)
    }
}