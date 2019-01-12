package com.snd.test.utils

import android.content.Context
import android.graphics.drawable.Drawable

object DrawableUtils {
    fun getInderminateDrawable(context: Context): Drawable {
        val attrs = intArrayOf(android.R.attr.indeterminateDrawable)
        val attrsIndeterminateDrawableIndex = 0
        val a = context.obtainStyledAttributes(android.R.style.Widget_ProgressBar, attrs)
        try {
            return a.getDrawable(attrsIndeterminateDrawableIndex)
        } finally {
            a.recycle()
        }
    }
}