package com.example.daggermvvmtemplate.ui

import android.arch.lifecycle.AndroidViewModel
import com.example.daggermvvmtemplate.App
import javax.inject.Inject

class MainViewModel @Inject constructor(private val app: App) : AndroidViewModel(app) {

}