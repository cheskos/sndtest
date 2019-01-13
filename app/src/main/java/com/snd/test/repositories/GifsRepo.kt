package com.snd.test.repositories

import com.snd.test.base.BaseApiCallback
import com.snd.test.base.BaseRepo
import com.snd.test.http.ApiService
import com.snd.test.model.PostResponseData
import javax.inject.Inject

interface Remote {
    fun search(keyword: String, offset: Int, limit: Int)
}

class GifsRepo @Inject internal constructor(
    private val apiService: ApiService
) : BaseRepo(), Remote {

    override fun search(keyword: String, offset: Int, limit: Int) {
        apiService.getAllPhotos()
            .enqueue(BaseApiCallback<PostResponseData>({ success ->

                apiResult.postValue(success)

            }, { failure ->

                failure.printStackTrace()
                apiResult.postValue(null)

            }))
    }
}