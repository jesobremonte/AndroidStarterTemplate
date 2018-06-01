package com.example.daggermvvmtemplate.injection

import android.content.Context
import com.example.daggermvvmtemplate.App
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideContext(application: App): Context {
        return application.applicationContext
    }

    @Provides
    fun provideSchedulers(): RxSchedulers {
        return RxSchedulers()
    }

}