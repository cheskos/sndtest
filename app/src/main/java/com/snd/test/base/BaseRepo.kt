package com.snd.test.base

import android.arch.lifecycle.MutableLiveData
import com.snd.test.model.PostResponseData

open class BaseRepo {

    val apiResult = MutableLiveData<PostResponseData>()

}