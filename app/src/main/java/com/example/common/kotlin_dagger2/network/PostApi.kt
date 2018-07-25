package com.example.common.kotlin_dagger2.network

import com.example.common.kotlin_dagger2.model.Post
import io.reactivex.Observable
import retrofit2.http.GET


interface PostApi {
    /**
     * Get the list of the pots from the API
     */
    @GET("/posts")
    fun getPosts(): Observable<List<Post>>
}