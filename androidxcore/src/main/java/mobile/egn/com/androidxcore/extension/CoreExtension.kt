package mobile.egn.com.androidxcore.extension

import android.util.Log

fun String.logI(content: String) {
    Log.i(this, content)
}
fun String.logE(content: String) {
    Log.e(this, content)
}