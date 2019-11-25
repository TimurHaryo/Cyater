package com.timtam.cyater.helper

import android.app.Activity
import android.app.Dialog
import android.os.Bundle
import android.view.Window
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.timtam.cyater.R
import kotlinx.android.synthetic.main.spinner_custom_dialog.*

class CustomListViewDialog(
    var activity: Activity,
    internal val adapter: RecyclerView.Adapter<*>
): Dialog(activity){
    private var mLayoutManager: RecyclerView.LayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.spinner_custom_dialog)

        mLayoutManager = LinearLayoutManager(activity)
        rvCurrency.layoutManager = mLayoutManager
        rvCurrency.adapter = adapter
    }

}