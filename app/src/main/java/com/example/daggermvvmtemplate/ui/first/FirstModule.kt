package com.example.daggermvvmtemplate.ui.first

import android.arch.lifecycle.ViewModel
import com.example.daggermvvmtemplate.injection.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
internal abstract class FirstModule {

    @ContributesAndroidInjector
    internal abstract fun firstFragment(): FirstFragment

    @Binds
    @IntoMap
    @ViewModelKey(FirstViewModel::class)
    abstract fun bindFirstViewModel(viewModel: FirstViewModel): ViewModel
}