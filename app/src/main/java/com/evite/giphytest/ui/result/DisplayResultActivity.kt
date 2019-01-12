package com.evite.giphytest.ui.result

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.evite.giphytest.R
import com.evite.giphytest.model.GifData
import com.evite.giphytest.ui.search.GifsResultFragment
import com.evite.giphytest.ui.search.GifsResultFragment.Companion.PARAM_LIST

class DisplayResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_result)

        val list = intent.getParcelableArrayListExtra<GifData>(PARAM_LIST)
        val f = GifsResultFragment.newInstance(list)
        fragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, f)
            .commit()
    }
}
