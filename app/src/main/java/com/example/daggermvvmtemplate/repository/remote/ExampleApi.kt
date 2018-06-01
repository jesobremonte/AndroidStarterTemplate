package com.example.daggermvvmtemplate.repository.remote

import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.POST

interface ExampleApi {

    @POST("api/endpoint")
    fun sendPostRequest(): Single<Response<Void>>

}