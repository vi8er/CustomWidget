package com.ys.customwidget

import android.app.Activity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_recyclerview.*

class RecyclerViewFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_recyclerview, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val str = arguments!!.getString("title")
        val adapter = DemoAdapter(activity as Activity, str!!)
        recyclerview.layoutManager = LinearLayoutManager(activity)
        recyclerview.adapter = adapter
    }

    class DemoAdapter: RecyclerView.Adapter<DemoViewHolder>{

        var activity: Activity? = null
        var str: String? = null

        constructor(activity: Activity,str: String){
            this.activity = activity
            this.str = str
        }

        override fun onCreateViewHolder(p0: ViewGroup, p1: Int): DemoViewHolder {
            val view = LayoutInflater.from(activity).inflate(R.layout.adapter_demo, p0,false)
            return DemoViewHolder(view)
        }

        override fun getItemCount(): Int {
            return 10
        }

        override fun onBindViewHolder(p0: DemoViewHolder, p1: Int) {
            p0.text!!.text = p1.toString()
        }
    }

    class DemoViewHolder: RecyclerView.ViewHolder{
        var text: TextView? = null
        constructor(item: View):super(item){
            text = item.findViewById(R.id.tv_text)
        }
    }
}