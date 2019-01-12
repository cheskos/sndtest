package com.snd.test.repositories

import com.snd.test.Constants
import com.snd.test.base.BaseApiCallback
import com.snd.test.base.BaseRepo
import com.snd.test.http.GifsService
import com.snd.test.model.SearchResponseData
import javax.inject.Inject

interface Remote {
    fun search(keyword: String, offset: Int, limit: Int)
}

class GifsRepo @Inject internal constructor(
    private val gifService: GifsService
) : BaseRepo(), Remote {

    private val apiKey = Constants.API_KEY

    override fun search(keyword: String, offset: Int, limit: Int) {
        gifService.search(keyword, offset, limit, apiKey)
            .enqueue(BaseApiCallback<SearchResponseData>({ success ->

                gifResults.postValue(success)

            }, { failure ->

                failure.printStackTrace()
                gifResults.postValue(null)

            }))
    }
}