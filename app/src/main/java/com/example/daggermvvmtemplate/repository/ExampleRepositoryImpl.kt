package com.example.daggermvvmtemplate.repository

import com.example.daggermvvmtemplate.App
import com.example.daggermvvmtemplate.repository.remote.ExampleApi
import io.reactivex.Completable
import javax.inject.Inject

class ExampleRepositoryImpl @Inject constructor(
        private val app: App,
        private val exampleApi: ExampleApi) : ExampleRepository {

    override fun doSomething(): Completable {
        return exampleApi.sendPostRequest()
                .toCompletable()
    }
}