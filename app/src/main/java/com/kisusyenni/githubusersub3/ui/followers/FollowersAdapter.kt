package com.kisusyenni.githubusersub3.ui.followers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kisusyenni.githubusersub3.data.source.local.entity.User
import com.kisusyenni.githubusersub3.databinding.ItemRowUserBinding

class FollowersAdapter: RecyclerView.Adapter<FollowersAdapter.FollowersViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    private var listFollowers = ArrayList<User>()

    fun setFollowers(followers: List<User>?) {
        if (followers == null) return
        this.listFollowers.clear()
        this.listFollowers.addAll(followers)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowersViewHolder {
        val itemRowUserBinding = ItemRowUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FollowersViewHolder(itemRowUserBinding)
    }

    override fun onBindViewHolder(holder: FollowersViewHolder, position: Int) {
        val follower = listFollowers[position]
        holder.bind(follower)
    }

    override fun getItemCount(): Int = listFollowers.size

    inner class FollowersViewHolder(private val binding: ItemRowUserBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(follower: User) {
            with(binding) {
                tvUserUsername.text = follower.username
                itemView.setOnClickListener {onItemClickCallback.onItemClicked("xxx")}
                Glide.with(itemView.context)
                    .load(follower.avatar)
                    .into(userAvatar)
            }
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(id: String)
    }
}