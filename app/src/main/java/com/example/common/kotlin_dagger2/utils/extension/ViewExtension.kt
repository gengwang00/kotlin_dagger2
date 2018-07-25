package com.example.common.kotlin_dagger2.utils.extension

import android.content.ContextWrapper
import android.support.v7.app.AppCompatActivity
import android.view.View

public class ViewExtension {

    public fun View.getParentActivity(): AppCompatActivity?{
        var context = this.context
        while (context is ContextWrapper) {
            if (context is AppCompatActivity) {
                return context
            }
            context = context.baseContext
        }
        return null
    }
}