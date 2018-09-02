package mobile.egn.com.mobile

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import dagger.android.support.DaggerAppCompatActivity
import mobile.egn.com.androidxcore.view.base.BaseFragment
import mobile.egn.com.mobile.firebase.AuthFragment


fun AppCompatActivity.addFragment(fragment: Fragment, frameId: Int, tag: String) {
    supportFragmentManager.beginTransaction()
            .add(frameId, fragment).addToBackStack(tag).commit()
}


fun AppCompatActivity.replaceFragment(fragment: Fragment, frameId: Int, tag: String) {
    supportFragmentManager.beginTransaction()
            .replace(frameId, fragment).addToBackStack(tag).commit()

}


fun AppCompatActivity.popFragment() {
    supportFragmentManager.popBackStack()
}


fun Fragment.addFragment(fragment: Fragment, frameId: Int, tag: String) {
    fragmentManager?.beginTransaction()?.add(frameId, fragment)?.addToBackStack(tag)
}

fun Fragment.replaceFragment(fragment: Fragment, frameId: Int, tag: String) {
    fragmentManager?.beginTransaction()?.add(frameId, fragment)?.addToBackStack(tag)
}

val AppCompatActivity.app: MobileApp
    get() = application as MobileApp

val BaseFragment.app: MobileApp
    get() = activity?.application as MobileApp
