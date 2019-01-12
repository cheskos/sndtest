package com.snd.test.base

import android.arch.lifecycle.MutableLiveData
import com.snd.test.model.SearchResponseData

open class BaseRepo {

    val gifResults = MutableLiveData<SearchResponseData>()

}