package com.example.daggermvvmtemplate.ui.first

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.daggermvvmtemplate.R
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.first_fragment.*
import javax.inject.Inject

class FirstFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: FirstViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.first_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders.of(this, viewModelFactory)
                .get(FirstViewModel::class.java)

        viewModel.result.observe(this, Observer {
            it?.let { message.text = it }
        })

        button.setOnClickListener { viewModel.doThing() }
    }

}
