package com.snd.test.repositories

import com.snd.test.base.BaseApiCallback
import com.snd.test.base.BaseRepo
import com.snd.test.http.ApiService
import com.snd.test.model.CommentResponseData
import com.snd.test.model.PostResponseData
import javax.inject.Inject

interface Remote {
    fun getAllPosts()
    fun getCommentsFor(id: Int)
}

class MainRepository @Inject internal constructor(
    private val apiService: ApiService
) : BaseRepo(), Remote {

    override fun getAllPosts() {
        apiService.getAllPosts()
            .enqueue(BaseApiCallback<List<PostResponseData.Post>>({ success ->

                postsLiveData.postValue(success)

            }, { failure ->

                failure.printStackTrace()
                postsLiveData.postValue(null)

            }))
    }

    override fun getCommentsFor(id: Int) {
        apiService.getCommentsFor(id)
            .enqueue(BaseApiCallback<List<CommentResponseData.Comment>>({ success ->
                commentsLiveData.postValue(success)
            }, { failure ->

                failure.printStackTrace()
                commentsLiveData.postValue(null)

            }))
    }
}