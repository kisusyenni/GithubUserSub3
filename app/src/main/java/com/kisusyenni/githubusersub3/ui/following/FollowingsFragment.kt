package com.kisusyenni.githubusersub3.ui.following

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.kisusyenni.githubusersub3.R
import com.kisusyenni.githubusersub3.databinding.FollowersFragmentBinding
import com.kisusyenni.githubusersub3.databinding.FollowingsFragmentBinding
import com.kisusyenni.githubusersub3.ui.followers.FollowersViewModel
import com.kisusyenni.githubusersub3.viewmodel.ViewModelFactory

class FollowingsFragment : Fragment() {

    private var _followingsFragmentBinding: FollowingsFragmentBinding? = null
    private val followingsFragmentBinding get() = _followingsFragmentBinding!!

    private lateinit var viewModel: FollowingsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _followingsFragmentBinding = FollowingsFragmentBinding.inflate(layoutInflater, container, false)
        return followingsFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val progressBar = followingsFragmentBinding.followingsProgressBar
        progressBar.isVisible = true

        if(activity != null) {
            val factory = ViewModelFactory.getInstance()
            viewModel = ViewModelProvider(this, factory)[FollowingsViewModel::class.java]

        }
    }

}