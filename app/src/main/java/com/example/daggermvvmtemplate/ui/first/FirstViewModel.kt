package com.example.daggermvvmtemplate.ui.first

import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.example.daggermvvmtemplate.App
import com.example.daggermvvmtemplate.injection.RxSchedulers
import com.example.daggermvvmtemplate.repository.ExampleRepository
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import javax.inject.Inject

class FirstViewModel @Inject constructor(private val app: App,
                                         private val schedulers: RxSchedulers,
                                         private val exampleRepository: ExampleRepository) : AndroidViewModel(app) {

    private val disposables = CompositeDisposable()

    private val resultMutable = MutableLiveData<String>()
    val result: LiveData<String>
        get() = resultMutable

    fun doThing() {
        disposables += exampleRepository.doSomething()
                .subscribeOn(schedulers.network)
                .observeOn(schedulers.main)
                .subscribe({
                    resultMutable.value = "success"
                }, {
                    Log.e(javaClass.name, it.message, it)
                    resultMutable.value = it.message
                })
    }

}
