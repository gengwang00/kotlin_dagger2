package com.example.common.kotlin_dagger2.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.databinding.BindingAdapter
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.example.common.kotlin_dagger2.base.BaseViewModel
import com.example.common.kotlin_dagger2.model.Post
import com.example.common.kotlin_dagger2.utils.BindingAdapters.getParentActivity

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