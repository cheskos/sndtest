package com.snd.test.ui.result

import android.os.Bundle
import android.support.v4.app.NavUtils
import android.support.v7.app.AppCompatActivity
import com.snd.test.R
import com.snd.test.model.CommentResponseData
import com.snd.test.ui.result.CommentsFragment.Companion.PARAM_LIST

class DisplayResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_result)

        val list = intent.getParcelableArrayListExtra<CommentResponseData.Comment>(PARAM_LIST)
        val f = CommentsFragment.newInstance(list)
        fragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, f)
            .commit()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        NavUtils.navigateUpFromSameTask(this)
    }
}
