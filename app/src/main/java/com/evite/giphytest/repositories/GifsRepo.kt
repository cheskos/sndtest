package com.evite.giphytest.repositories

import android.util.Log
import com.evite.giphytest.Constants
import com.evite.giphytest.base.BaseApiCallback
import com.evite.giphytest.base.BaseRepo
import com.evite.giphytest.http.GifsService
import com.evite.giphytest.model.SearchResponseData
import javax.inject.Inject

interface Remote {
    fun search(keyword: String)
}

class GifsRepo @Inject internal constructor(
    private val gifService: GifsService
) : BaseRepo(), Remote {

    private val apiKey = Constants.API_KEY

//    companion object {
//        private var INSTANCE: GifsRepo? = null
//
//        @JvmStatic fun instance(gifService: GifsService): GifsRepo {
//            if (INSTANCE == null) {
//                synchronized(GifsRepo::class.java) {
//                    INSTANCE = GifsRepo(gifService)
//                }
//            }
//            return INSTANCE!!
//        }
//    }

    override fun search(keyword: String) {
        gifService.search(keyword, apiKey)
            .enqueue(BaseApiCallback<SearchResponseData>({ success ->
            Log.d("TAG", "YAY")
        }, { failure ->
            Log.e("TAG", "NAY :(")
        }))
    }
}