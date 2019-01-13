package com.snd.test.base

import android.arch.lifecycle.MutableLiveData
import com.snd.test.model.CommentResponseData
import com.snd.test.model.PostResponseData

open class BaseRepo {

    val postsLiveData = MutableLiveData<List<PostResponseData.Post>>()
    val commentsLiveData = MutableLiveData<List<CommentResponseData.Comment>>()

}