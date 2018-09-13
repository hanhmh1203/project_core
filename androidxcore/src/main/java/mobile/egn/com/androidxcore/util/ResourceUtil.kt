package mobile.egn.com.androidxcore.util

import android.app.Application
import android.content.Context
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

class ResourceUtil {
    companion object {
        fun string(@StringRes resId: Int, context: Context) = context.getString(resId)!!
        fun string(@StringRes res: Int, vararg formatArgs: Any, context: Context) = context.getString(res, formatArgs)
        fun color(@ColorRes res: Int, context: Context): Int = context.resources.getColor(res)
        fun drawable(@DrawableRes res: Int, context: Context) = context.resources.getDrawable(res)
    }
}