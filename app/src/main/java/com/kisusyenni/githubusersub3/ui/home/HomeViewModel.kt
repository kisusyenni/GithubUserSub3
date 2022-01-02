package com.kisusyenni.githubusersub3.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.kisusyenni.githubusersub3.data.source.GithubUserRepository
import com.kisusyenni.githubusersub3.data.source.local.entity.User

class HomeViewModel(private val repository: GithubUserRepository): ViewModel() {
    fun getUsers(): LiveData<List<User>> = repository.getUsers()
}