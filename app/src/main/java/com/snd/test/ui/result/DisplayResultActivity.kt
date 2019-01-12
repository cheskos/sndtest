package com.snd.test.ui.result

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.snd.test.R
import com.snd.test.model.GifData
import com.snd.test.ui.search.GifsResultFragment
import com.snd.test.ui.search.GifsResultFragment.Companion.PARAM_LIST

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
