package com.ys.customwidget

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv_intercepthorizontalviewpager.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v!!.id == R.id.tv_intercepthorizontalviewpager) {
            startActivity(Intent(this,CustomTabActivity::class.java))
        }
    }
}
