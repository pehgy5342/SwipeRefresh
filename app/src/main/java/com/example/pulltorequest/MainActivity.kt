package com.example.pulltorequest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    var myList = ArrayList<MyData>()
    val myAdapter = MyAdapter(myList)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()

    }


    fun initView() {

        myList.add(MyData("name : 1"))
        recyclerView.layoutManager = GridLayoutManager(this, 2) as RecyclerView.LayoutManager?
        recyclerView.adapter = myAdapter

//        swipeRefreshLayout.setProgressViewOffset(true, 50, 100)
        //progress的size
//        swipeRefreshLayout.setSize(SwipeRefreshLayout.LARGE)
//        swipeRefreshLayout.isEnabled = true
        swipeRefreshLayout.setOnRefreshListener(listener)
    }

    val listener = SwipeRefreshLayout.OnRefreshListener {

        for (i in 0..1) {
            val random = Random().nextInt(20)
            myList.add(MyData("name : $random"))

        }

        //將list亂序排列
        myList.shuffle()

        //adapter畫面更新
        myAdapter.notifyDataSetChanged()

        //更新進度條停止顯示
        swipeRefreshLayout.isRefreshing = false

    }
}
