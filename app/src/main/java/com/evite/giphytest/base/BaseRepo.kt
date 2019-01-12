package com.evite.giphytest.base

import android.arch.lifecycle.MutableLiveData
import com.evite.giphytest.model.SearchResponseData

open class BaseRepo {

    val gifResults = MutableLiveData<SearchResponseData>()

}