package com.example.daggermvvmtemplate.repository

import io.reactivex.Completable

interface ExampleRepository {

    fun doSomething(): Completable

}