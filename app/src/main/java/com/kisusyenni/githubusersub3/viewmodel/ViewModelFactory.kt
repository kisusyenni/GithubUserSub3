package com.kisusyenni.githubusersub3.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kisusyenni.githubusersub3.data.source.GithubUserRepository
import com.kisusyenni.githubusersub3.di.Injection
import com.kisusyenni.githubusersub3.ui.detail.DetailViewModel
import com.kisusyenni.githubusersub3.ui.followers.FollowersViewModel
import com.kisusyenni.githubusersub3.ui.following.FollowingsViewModel
import com.kisusyenni.githubusersub3.ui.home.HomeViewModel

class ViewModelFactory private constructor(private val githubUserRepository: GithubUserRepository) : ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(): ViewModelFactory =
            instance ?: synchronized(this) {
                ViewModelFactory(Injection.provideRepository()).apply { instance = this }
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                HomeViewModel(githubUserRepository) as T
            }
            modelClass.isAssignableFrom(FollowersViewModel::class.java) -> {
                FollowersViewModel(githubUserRepository) as T
            }
            modelClass.isAssignableFrom(FollowingsViewModel::class.java) -> {
                FollowingsViewModel(githubUserRepository) as T
            }
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> {
                DetailViewModel(githubUserRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}