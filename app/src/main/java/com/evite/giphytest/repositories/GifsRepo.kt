package com.evite.giphytest.repositories

import com.evite.giphytest.Constants
import com.evite.giphytest.base.BaseApiCallback
import com.evite.giphytest.base.BaseRepo
import com.evite.giphytest.http.GifsService
import com.evite.giphytest.model.SearchResponseData
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