package mobile.egn.com.androidxcore.view.abs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import dagger.android.support.DaggerFragment
import mobile.egn.com.androidxcore.R

abstract class AbsFragment : DaggerFragment() {
    abstract fun layoutId(): Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_base, container, false) as FrameLayout
        val contentFragmentView = inflater.inflate(layoutId(), view, false)
        contentFragmentView.id = R.id.base_content
        view.addView(contentFragmentView, FrameLayout.LayoutParams(-1, -1)) // short for match_parent
        return view

    }

//
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        val view = inflater!!.inflate(layoutId(), container, false)
//        return view
//    }
//    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
//        val view = inflater!!.inflate(layoutId(), container, false)
//        return view
//    }
}