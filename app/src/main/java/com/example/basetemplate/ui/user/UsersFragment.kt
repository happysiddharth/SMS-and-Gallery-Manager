package com.example.basetemplate.ui.user

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.basetemplate.R
import com.example.basetemplate.data.model.UserItem
import com.example.basetemplate.di.component.FragmentComponent
import com.example.basetemplate.ui.base.BaseFragment
import com.example.basetemplate.ui.user.users.UsersAdapter
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class UsersFragment : BaseFragment<UsersFragmentViewModel>() {
    companion object{
        const val TAG = "UsersFragment"
    }
    private lateinit var recyclerView: RecyclerView
    private lateinit var usersAdapter:UsersAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager
    override fun setUpView(view: View) {
        recyclerView = view.findViewById(R.id.usersRV)
        usersAdapter = UsersAdapter(viewLifecycleOwner)
        linearLayoutManager = LinearLayoutManager(context)
        recyclerView.apply {
            adapter = usersAdapter
            layoutManager = linearLayoutManager
        }
    }

    override fun getResourceId(): Int = R.layout.users_layout

    override fun injectDependencies(fragmentComponent: FragmentComponent) {
        fragmentComponent
            .inject(this)
    }

    override fun setObservers(view: View) {
        super.setObservers(view)
        viewModel.users.observe(this){data->
            GlobalScope.launch {
                usersAdapter.submitData(data)
            }
        }

    }
}