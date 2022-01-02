package com.kisusyenni.githubusersub3.di

import com.kisusyenni.githubusersub3.data.source.GithubUserRepository
import com.kisusyenni.githubusersub3.data.source.remote.RemoteDataSource

object Injection {
    fun provideRepository(): GithubUserRepository {

        val remoteDataSource = RemoteDataSource.getInstance()

        return GithubUserRepository.getInstance(remoteDataSource)
    }
}