package com.kisusyenni.githubusersub3.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kisusyenni.githubusersub3.data.source.local.entity.User
import com.kisusyenni.githubusersub3.databinding.ItemRowUserBinding

class UserListAdapter: RecyclerView.Adapter<UserListAdapter.UsersViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    private var listUsers = ArrayList<User>()

    fun setUsers(users: List<User>?) {
        if (users == null) return
        this.listUsers.clear()
        this.listUsers.addAll(users)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        val itemRowUserBinding = ItemRowUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UsersViewHolder(itemRowUserBinding)
    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        val follower = listUsers[position]
        holder.bind(follower)
    }

    override fun getItemCount(): Int = listUsers.size

    inner class UsersViewHolder(private val binding: ItemRowUserBinding) : RecyclerView.ViewHolder(binding.root) {
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
        fun onItemClicked(username: String)
    }
}