package com.example.common.kotlin_dagger2.viewmodel

import android.arch.lifecycle.MutableLiveData

import com.example.common.kotlin_dagger2.base.BaseViewModel
import com.example.common.kotlin_dagger2.model.Post

class PostViewModel : BaseViewModel() {
    private val postTitle = MutableLiveData<String>()
    private val postBody = MutableLiveData<String>()

    fun bind(post: Post){
        postTitle.value = post.title
        postBody.value = post.body
    }

    fun getPostTitle():MutableLiveData<String>{
        return postTitle
    }

    fun getPostBody():MutableLiveData<String>{
        return postBody
    }


}