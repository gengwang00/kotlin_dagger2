package com.example.common.kotlin_dagger2.injection.component

import com.example.common.kotlin_dagger2.module.NetworkModule
import com.example.common.kotlin_dagger2.viewmodel.PostHeaderViewModel
import com.example.common.kotlin_dagger2.viewmodel.PostListViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {

    fun inject(postListViewModel: PostListViewModel)
    fun inject(postHeaderViewModel: PostHeaderViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector

        fun networkModule(networkModule: NetworkModule): Builder
    }
}