package com.example.common.kotlin_dagger2.viewmodel

import com.example.common.kotlin_dagger2.base.BaseViewModel
import com.example.common.kotlin_dagger2.pojo.MyInjectionClass
import javax.inject.Inject

class PostHeaderViewModel : BaseViewModel() {

    @Inject
    lateinit var myClass: MyInjectionClass


    var getHeader: String  =  myClass.getPostHeader()


}