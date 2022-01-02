package com.kisusyenni.githubusersub3.ui.home

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.kisusyenni.githubusersub3.databinding.ActivityHomeBinding
import com.kisusyenni.githubusersub3.ui.adapter.UserListAdapter
import com.kisusyenni.githubusersub3.ui.detail.DetailActivity
import com.kisusyenni.githubusersub3.viewmodel.ViewModelFactory

class HomeActivity : AppCompatActivity(), UserListAdapter.OnItemClickCallback {

    private var _activityHomeBinding: ActivityHomeBinding? = null
    private val activityHomeBinding get() = _activityHomeBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _activityHomeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(activityHomeBinding.root)
        val factory = ViewModelFactory.getInstance()
        val viewModel = ViewModelProvider(this, factory)[HomeViewModel::class.java]

        val userListAdapter = UserListAdapter()

        viewModel.getUsers().observe(this, {users ->
            userListAdapter.setUsers(users)
            userListAdapter.setOnItemClickCallback(this)
            with(activityHomeBinding.rvUsers) {
                layoutManager = if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    GridLayoutManager(context, 3)
                } else {
                    GridLayoutManager(context, 2)
                }
                setHasFixedSize(true)
                adapter = userListAdapter
            }

        })

    }

    override fun onItemClicked(username: String) {
        val detailIntent = Intent(this@HomeActivity, DetailActivity::class.java)
        detailIntent.putExtra(DetailActivity.EXTRA_USER, username)
        startActivity(detailIntent)
    }

    override fun onDestroy() {
        super.onDestroy()
        _activityHomeBinding = null
    }
}