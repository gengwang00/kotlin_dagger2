package com.example.common.kotlin_dagger2.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.view.View
import com.example.common.kotlin_dagger2.R
import com.example.common.kotlin_dagger2.base.BaseViewModel
import com.example.common.kotlin_dagger2.model.Post
import com.example.common.kotlin_dagger2.network.PostApi
import com.example.common.kotlin_dagger2.ui.post.PostListAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PostListViewModel : BaseViewModel() {
    @Inject
    lateinit var postApi: PostApi

    private lateinit var subscription: Disposable

    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()

    val postListAdapter: PostListAdapter = PostListAdapter()

    val errorMessage:MutableLiveData<Int> = MutableLiveData()
    val errorClickListener = View.OnClickListener { loadPosts() }

    init {
        loadPosts()
    }

    private fun loadPosts(){
        subscription = postApi.getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { onRetrievePostListStart() }
                .doOnTerminate { onRetrievePostListFinish() }
                .subscribe(
                        { result -> onRetrievePostListSuccess(result) },
                        { e -> onRetrievePostListError(e) }
                )
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }

    private fun onRetrievePostListStart(){
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null
    }

    private fun onRetrievePostListFinish(){
        loadingVisibility.value = View.GONE
    }

    private fun onRetrievePostListSuccess(postList:List<Post>){
        postListAdapter.updatePostList(postList)
    }

    private fun onRetrievePostListError( e: Throwable){
        errorMessage.value = R.string.post_error

        println(e.localizedMessage)
    }
}