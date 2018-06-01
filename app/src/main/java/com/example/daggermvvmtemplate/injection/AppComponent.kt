package com.example.daggermvvmtemplate.injection

import com.example.daggermvvmtemplate.App
import com.example.daggermvvmtemplate.repository.RepositoryModule
import com.example.daggermvvmtemplate.ui.MainModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    ViewModelModule::class,
    MainModule::class,
    RepositoryModule::class
])
interface AppComponent : AndroidInjector<App> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>()
}