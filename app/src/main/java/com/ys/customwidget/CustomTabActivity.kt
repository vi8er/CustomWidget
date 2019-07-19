package com.ys.customwidget

import android.graphics.Typeface
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_intercepthoizontalviewpager.*

class CustomTabActivity: AppCompatActivity() {

    val fragments = ArrayList<Fragment>()
    val title = arrayOf("页面一","页面二","页面三","页面四","页面五")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intercepthoizontalviewpager)
        for (i in 0..4){
            val bundle = Bundle()
            bundle.putString("title",title[i])
            val fragment = RecyclerViewFragment()
            fragment.arguments = bundle
            fragments.add(fragment)
        }

        val tablayout = tablayout
        tablayout.setTabSelectTextSize(DimensUtils.dip2px(this,17f).toFloat())
        tablayout.setTabSelectTypeface(Typeface.defaultFromStyle(Typeface.BOLD))

        val viewpager = viewpager
        tablayout.setupWithViewPager(viewpager)
        viewpager.offscreenPageLimit = 5

        val adapter = object :FragmentPagerAdapter(supportFragmentManager){
            override fun getItem(p0: Int): Fragment {
                return fragments[p0]
            }

            override fun getCount(): Int {
                return fragments.size
            }

            override fun getPageTitle(position: Int): CharSequence? {
                return title[position]
            }
        }
        viewpager.adapter = adapter
    }

}