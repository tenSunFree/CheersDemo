package com.home.cheersdemo.view.adapter

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class MainActivityPagerAdapter(
    private val context: Context,
    private val layoutArray: IntArray
) : PagerAdapter() {

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val layoutInflater: LayoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutInflater.inflate(layoutArray[position], container, false)
        container.addView(view)
        return view
    }

    override fun getCount(): Int {
        return layoutArray.size
    }

    override fun isViewFromObject(view: View, obj: Any): Boolean {
        return view == obj
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        if (`object` is View) container.removeView(`object`)
    }
}