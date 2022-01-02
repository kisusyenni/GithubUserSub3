package com.kisusyenni.githubusersub3.ui.followers

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.kisusyenni.githubusersub3.R
import com.kisusyenni.githubusersub3.databinding.FollowersFragmentBinding
import com.kisusyenni.githubusersub3.ui.adapter.UserListAdapter
import com.kisusyenni.githubusersub3.viewmodel.ViewModelFactory

class FollowersFragment : Fragment(), UserListAdapter.OnItemClickCallback {

    private var _followersFragmentBinding: FollowersFragmentBinding? = null
    private val followersFragmentBinding get() = _followersFragmentBinding!!

    private lateinit var viewModel: FollowersViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _followersFragmentBinding = FollowersFragmentBinding.inflate(layoutInflater, container, false)
        return followersFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val progressBar = followersFragmentBinding.followersProgressBar
        progressBar.isVisible = true

        if(activity != null) {
            val factory = ViewModelFactory.getInstance()
            viewModel = ViewModelProvider(this, factory)[FollowersViewModel::class.java]

        }
    }

    override fun onItemClicked(id: String) {
        TODO("Not yet implemented")
    }

}