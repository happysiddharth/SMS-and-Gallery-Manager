package com.example.basetemplate.ui.user.users

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.DiffUtil
import com.example.basetemplate.R
import com.example.basetemplate.data.model.UserItem
import com.example.basetemplate.ui.base.BasePagingAdapter

class UsersAdapter(parentLifecycle:LifecycleOwner) :
    BasePagingAdapter<UserItem,UserViewHolder>(parentLifecycle.lifecycle,MovieComparator){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder =
        UserViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.user_layout,parent,false)
        )

    object MovieComparator : DiffUtil.ItemCallback<UserItem>() {
        override fun areItemsTheSame(oldItem: UserItem, newItem: UserItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: UserItem, newItem: UserItem): Boolean {
            return oldItem == newItem
        }
    }

}