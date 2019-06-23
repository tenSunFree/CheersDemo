package com.home.cheersdemo.view.activity

import android.content.Intent
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import com.home.cheersdemo.R
import com.home.cheersdemo.helper.SharedPreferencesManager
import com.home.cheersdemo.view.adapter.MainActivityPagerAdapter
import com.rd.animation.type.AnimationType
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        isSkipWelcomeActivity()
        initializeView()
    }

    /**
     * 判斷是否要略過WelcomeActivity
     */
    private fun isSkipWelcomeActivity() {
        if (SharedPreferencesManager.getBoolean(
                R.string.shared_preferences_is_skip_welcome_activity_key, false
            )
        ) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun initializeView() {
        pageIndicatorView.setAnimationType(AnimationType.WORM)
        val layoutArray: IntArray = intArrayOf(
            R.layout.activity_welcome_view_page_first_item,
            R.layout.activity_welcome_view_page_second_item,
            R.layout.activity_welcome_view_page_third_item,
            R.layout.activity_welcome_view_page_fourth_item
        )
        val myViewPagerAdapter = MainActivityPagerAdapter(this, layoutArray)
        viewPager?.adapter = myViewPagerAdapter
        viewPager?.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageSelected(position: Int) {
                viewPager?.currentItem = position
            }

            override fun onPageScrolled(position: Int, arg1: Float, arg2: Int) {}
            override fun onPageScrollStateChanged(arg0: Int) {}
        })
        val pageLimit = 4
        viewPager?.offscreenPageLimit = pageLimit
        startFrameLayout.setOnClickListener { launchMainActivity() }
    }

    private fun launchMainActivity() {
        startActivity(Intent(this@WelcomeActivity, MainActivity::class.java))
        finish()
    }
}
