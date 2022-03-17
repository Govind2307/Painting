package com.example.painting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageButton
import androidx.core.view.isVisible
import androidx.recyclerview.widget.AdapterListUpdateCallback
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {


    lateinit var up:ImageButton
    lateinit var recycler: RecyclerView
    var menu: List<Abc> = listOf(
        Abc(
            "https://surface678.com/wp-content/uploads/elementor/thumbs/edited_wake_tech-ovagsl83z9l43ggkcb0jjyd5vo1na0fp5ta32k5qwg.jpg",
            "Leonardo",
            "popular",
            "writer"
        ),
        Abc(
            "https://surface678.com/wp-content/uploads/elementor/thumbs/edited_wake_tech-ovagsl83z9l43ggkcb0jjyd5vo1na0fp5ta32k5qwg.jpg",
            "Leonardo",
            "popular",
            "writer"
        ),
        Abc(
            "https://surface678.com/wp-content/uploads/elementor/thumbs/edited_wake_tech-ovagsl83z9l43ggkcb0jjyd5vo1na0fp5ta32k5qwg.jpg",
            "Leonardo",
            "popular",
            "writer"
        ),
        Abc(
            "https://surface678.com/wp-content/uploads/elementor/thumbs/edited_wake_tech-ovagsl83z9l43ggkcb0jjyd5vo1na0fp5ta32k5qwg.jpg",
            "Leonardo",
            "popular",
            "writer"
        )
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        up = findViewById(R.id.up)
        up.setOnClickListener{
            recycler.smoothScrollToPosition(0)

    }
        initView();
    }


    private fun initView() {


//        val adapter = adapter(context = MainActivity(), emptyList())
        recycler = findViewById(R.id.recyclerview)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = Adapter(this, menu)

        recycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                up.isVisible=layoutManager.findLastVisibleItemPosition()!=0
            }
        })
        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(recycler)
    }
}