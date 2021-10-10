package com.example.basetemplate.di.component

import android.app.Activity
import com.example.basetemplate.di.module.ViewHolderModule
import com.example.basetemplate.di.ViewHolderScope
import com.example.basetemplate.ui.dashboard.sms.UserViewHolder
import com.example.basetemplate.ui.gallery.images.ImageItemViewHolder
import dagger.Component
import dagger.Provides

@ViewHolderScope
@Component(
    modules = [
        ViewHolderModule::class
    ],
    dependencies = [
        ApplicationComponent::class,
    ]
)
interface ViewHolderComponent {
    fun inject(userItemViewModel: UserViewHolder)
    fun inject(imageItemViewModel: ImageItemViewHolder)


}