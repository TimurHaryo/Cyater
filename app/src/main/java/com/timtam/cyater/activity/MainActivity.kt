package com.timtam.cyater.activity

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.appcompat.app.ActionBar
import androidx.appcompat.widget.Toolbar
import com.timtam.cyater.R
import com.timtam.cyater.adapter.PagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var mPagerAdapter: PagerAdapter
    private lateinit var myToolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mPagerAdapter = PagerAdapter(supportFragmentManager)
        pagerMain.adapter = mPagerAdapter

        tabLayoutMain.setupWithViewPager(pagerMain)
    }

}
