package com.example.basetemplate.ui.user.users

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.basetemplate.R
import com.example.basetemplate.data.model.UserItem
import com.example.basetemplate.di.component.ViewHolderComponent
import com.example.basetemplate.ui.base.BaseItemViewHolder
import com.example.basetemplate.util.log.Logger
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class UserViewHolder(private val view:View):BaseItemViewHolder<UserItem,UserViewModel>(view) {
    private lateinit var image:ImageView
    private lateinit var tvName:TextView
    override fun setUpObservers() {
        viewModel.data.observe(this){
            tvName.text = it.name
            Glide.with(view.findViewById<ImageView>(R.id.image)).load(
                it?.image?.medium
            ).into(view.findViewById<ImageView>(R.id.image))
            Toast.makeText(view.context,it.name,Toast.LENGTH_SHORT).show()
        }


    }

    override fun injectDependencies(viewHolderComponent: ViewHolderComponent) {
        viewHolderComponent
            .inject(this)

    }

    override fun setUpView(view: View) {
        tvName = view.findViewById(R.id.textView)
        image =  view.findViewById(R.id.image)
        image.setOnClickListener {
            viewModelScope .launch {
                delay(2000)
                viewModel.data.postValue(viewModel.data.value)
            }
        }

    }
}