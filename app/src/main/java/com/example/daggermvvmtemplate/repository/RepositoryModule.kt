package com.example.daggermvvmtemplate.repository

import com.example.daggermvvmtemplate.App
import com.example.daggermvvmtemplate.repository.remote.ExampleApi
import com.example.daggermvvmtemplate.repository.remote.RemoteModule
import dagger.Module
import dagger.Provides

@Module(includes = [
    RemoteModule::class
])
class RepositoryModule {

    @Provides
    fun providesExampleRepository(app: App,
                                  exampleApi: ExampleApi): ExampleRepository {
        return ExampleRepositoryImpl(app, exampleApi)
    }
}