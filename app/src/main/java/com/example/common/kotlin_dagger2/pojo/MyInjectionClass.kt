package com.example.common.kotlin_dagger2.pojo

class MyInjectionClass {
    private val myName : String = "MyInjectionClass"


    fun getMyName() : String {
        return myName
    }

    fun getPostHeader() : String {
        return "Post Header"
    }
}