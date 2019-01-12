package com.snd.test

import android.app.Activity
import android.support.annotation.StringRes
import android.support.design.widget.CoordinatorLayout
import android.support.design.widget.Snackbar
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.RelativeLayout
import retrofit2.Response
import java.io.IOException

fun <T> Response<T>.populateThrowable(): Throwable {
    var errorBodyString: String? = null
    try {
        val errorBody = this.errorBody()
        if (errorBody != null) {
            errorBodyString = errorBody.string()
        }
    } catch (e: IOException) {
        e.printStackTrace()
    }

    return Throwable(String.format("%s\n%s", this.message(), errorBodyString))
}

fun EditText.onChange(cb: (String) -> Unit) {
    this.addTextChangedListener(object: TextWatcher {
        override fun afterTextChanged(s: Editable?) { cb(s.toString()) }
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
    })
}

val Activity.coordinator : CoordinatorLayout?
    get() = findViewById(R.id.coordinator)

fun View.snackbar(text: CharSequence, duration: Int = Snackbar.LENGTH_SHORT): Snackbar {
    val snack = Snackbar.make(this, text, duration)
    snack.show()
    return snack
}

fun View.snackbar(@StringRes text: Int, duration: Int = Snackbar.LENGTH_SHORT): Snackbar {
    val str = this.context.getString(text)
    return this.snackbar(str, duration)
}

fun Activity.snackbar(view: View, text: CharSequence, duration: Int = Snackbar.LENGTH_LONG): Snackbar {
    return view.snackbar(text, duration)
}

fun Activity.snackbar(view: View, @StringRes text: Int, duration: Int = Snackbar.LENGTH_LONG): Snackbar {
    return view.snackbar(text, duration)
}