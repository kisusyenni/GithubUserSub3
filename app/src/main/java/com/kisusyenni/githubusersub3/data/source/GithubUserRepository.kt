package com.kisusyenni.githubusersub3.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kisusyenni.githubusersub3.data.source.local.entity.User
import com.kisusyenni.githubusersub3.data.source.remote.RemoteDataSource
import com.kisusyenni.githubusersub3.data.source.remote.response.UsersResponse

class GithubUserRepository private constructor(private val remoteDataSource: RemoteDataSource): GithubUserDataSource {
    companion object {
        @Volatile
        private var instance: GithubUserRepository? = null
        fun getInstance(remoteData: RemoteDataSource): GithubUserRepository =
            instance ?: synchronized(this) {
                instance ?: GithubUserRepository(remoteData).apply { instance = this }
            }
    }

    override fun getUsers(): LiveData<List<User>> {
        val userResults = MutableLiveData<List<User>>()

        remoteDataSource.getUsers(object: RemoteDataSource.LoadUsersCallback{
            override fun onUsersLoaded(users: List<UsersResponse>?) {
                val list = ArrayList<User>()
                if(users != null) {
                    for (data in users) {
                        val user = User(
                            data.login,
                            data.avatarUrl)
                        list.add(user)
                    }
                    userResults.postValue(list)
                }
            }
        })
        return userResults
    }
}