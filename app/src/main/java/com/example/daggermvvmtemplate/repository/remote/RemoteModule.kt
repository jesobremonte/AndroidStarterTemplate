package com.example.daggermvvmtemplate.repository.remote

import com.example.daggermvvmtemplate.injection.RxSchedulers
import com.example.daggermvvmtemplate.BuildConfig
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


@Module
class RemoteModule {

    @Provides
    fun provideExampleApi(retrofit: Retrofit): ExampleApi {
        return retrofit.create(ExampleApi::class.java)
    }

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, schedulers: RxSchedulers): Retrofit {
        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory
                        .createWithScheduler(schedulers.network))
                .client(okHttpClient)
                .baseUrl(BuildConfig.URL_BASE)
                .build()
    }

    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val clientBuilder = OkHttpClient.Builder()
        clientBuilder.readTimeout(10, TimeUnit.SECONDS)
        clientBuilder.connectTimeout(10, TimeUnit.SECONDS)
        @Suppress("ConstantConditionIf")
        if (BuildConfig.DEBUG) {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            clientBuilder.addInterceptor(interceptor)
        }
        return clientBuilder.build()
    }
}