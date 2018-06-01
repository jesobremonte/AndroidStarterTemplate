package com.example.daggermvvmtemplate.ui

import android.arch.lifecycle.ViewModel
import com.example.daggermvvmtemplate.injection.ViewModelKey
import com.example.daggermvvmtemplate.ui.first.FirstModule
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
internal abstract class MainModule {

    @ContributesAndroidInjector(modules = [
        FirstModule::class
    ])
    internal abstract fun mainActivity(): MainActivity

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel

}