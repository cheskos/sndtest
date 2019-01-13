package com.snd.test.ui.result

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.snd.test.R
import com.snd.test.model.PostResponseData
import com.snd.test.ui.result.GifsResultFragment.Companion.PARAM_LIST

class DisplayResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_result)

        val list = intent.getParcelableArrayListExtra<PostResponseData.Post>(PARAM_LIST)
        val f = GifsResultFragment.newInstance(list)
        fragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, f)
            .commit()
    }
}
