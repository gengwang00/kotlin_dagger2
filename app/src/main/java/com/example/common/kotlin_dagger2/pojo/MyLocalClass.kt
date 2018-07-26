package com.example.common.kotlin_dagger2.pojo

class MyLocalClass {
    private val myName : String = "MyLocalClass"


    fun getMyName() : String {
        return myName
    }

    fun getPostHeader() : String {
        return "MyLocalClass"
    }

    override fun toString(): String {
        return getMyName()
    }
}