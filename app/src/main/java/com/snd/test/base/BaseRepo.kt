package com.snd.test.base

import android.arch.lifecycle.MutableLiveData
import com.snd.test.model.CommentResponseData
import com.snd.test.model.PostResponseData
import com.snd.test.model.SingleLiveEvent

open class BaseRepo {

    val postsLiveData = MutableLiveData<List<PostResponseData.Post>>()
    val commentsLiveData = SingleLiveEvent<List<CommentResponseData.Comment>>()

}