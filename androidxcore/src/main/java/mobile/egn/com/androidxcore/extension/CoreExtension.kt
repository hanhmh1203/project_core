package mobile.egn.com.androidxcore.extension

import android.content.SharedPreferences
import android.util.Log

fun String.logI(content: String) {
    Log.i(this, content)
}

fun String.logE(content: String) {
    Log.e(this, content)
}


// sharedpreference
 //    fun defaultPrefs(context: Context): SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
//    fun customPrefs(context: Context, name: String): SharedPreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE)
//    private fun prefs(): SharedPreferences = MobileApp.INSTANCE.getSharedPreferences(name, Context.MODE_PRIVATE)
//fun setThem(theme: Int) {
//    prefs().setValue(KEY_THEME, theme)
//}
//
//fun them(): Int {
//    return prefs().getInt(KEY_THEME, Constant.THEMEBOY)
//}

inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
    val editor = this.edit()
    operation(editor)
    editor.apply()
}

fun SharedPreferences.setValue(key: String, value: Any?) {
    when (value) {
        is String? -> edit { it.putString(key, value) }
        is Int -> edit { it.putInt(key, value) }
        is Boolean -> edit { it.putBoolean(key, value) }
        is Float -> edit { it.putFloat(key, value) }
        is Long -> edit { it.putLong(key, value) }
        else -> throw UnsupportedOperationException("Not yet implemented")
    }
}

inline fun <reified T : Any> SharedPreferences.get(key: String, defaultValue: T? = null): T? {
    return when (T::class) {
        String::class -> getString(key, defaultValue as? String) as T?
        Int::class -> getInt(key, defaultValue as? Int ?: -1) as T?
        Boolean::class -> getBoolean(key, defaultValue as? Boolean ?: false) as T?
        Float::class -> getFloat(key, defaultValue as? Float ?: -1f) as T?
        Long::class -> getLong(key, defaultValue as? Long ?: -1) as T?
        else -> throw UnsupportedOperationException("Not yet implemented")
    }
}