package com.kisusyenni.githubusersub3.data.source

import androidx.lifecycle.LiveData
import com.kisusyenni.githubusersub3.data.source.local.entity.User

interface GithubUserDataSource {
    fun getUsers(): LiveData<List<User>>
}