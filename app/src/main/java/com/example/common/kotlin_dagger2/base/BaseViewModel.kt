package com.example.common.kotlin_dagger2.base

import android.arch.lifecycle.ViewModel
import com.example.common.kotlin_dagger2.injection.component.DaggerViewModelInjector
import com.example.common.kotlin_dagger2.injection.component.ViewModelInjector
import com.example.common.kotlin_dagger2.module.NetworkModule
import com.example.common.kotlin_dagger2.viewmodel.PostHeaderViewModel
import com.example.common.kotlin_dagger2.viewmodel.PostListViewModel

abstract class BaseViewModel: ViewModel() {

    private val injector: ViewModelInjector = DaggerViewModelInjector.builder()
            .networkModule(NetworkModule)
            .build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is PostListViewModel -> injector.inject(this)
            is PostHeaderViewModel -> injector.inject(this)
        }
    }
}