package com.example.painting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {


    lateinit var recycler: RecyclerView
    var menu: List<abc> = listOf(
        abc(
            "https://surface678.com/wp-content/uploads/elementor/thumbs/edited_wake_tech-ovagsl83z9l43ggkcb0jjyd5vo1na0fp5ta32k5qwg.jpg",
            "Leonardo",
            "popular",
            "writer"
        ),
        abc(
            "https://surface678.com/wp-content/uploads/elementor/thumbs/edited_wake_tech-ovagsl83z9l43ggkcb0jjyd5vo1na0fp5ta32k5qwg.jpg",
            "Leonardo",
            "popular",
            "writer"
        ),
        abc(
            "https://surface678.com/wp-content/uploads/elementor/thumbs/edited_wake_tech-ovagsl83z9l43ggkcb0jjyd5vo1na0fp5ta32k5qwg.jpg",
            "Leonardo",
            "popular",
            "writer"
        ),
        abc(
            "https://surface678.com/wp-content/uploads/elementor/thumbs/edited_wake_tech-ovagsl83z9l43ggkcb0jjyd5vo1na0fp5ta32k5qwg.jpg",
            "Leonardo",
            "popular",
            "writer"
        )
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView();


    }



    private fun initView() {



//        val adapter = adapter(context = MainActivity(), emptyList())
        recycler = findViewById(R.id.recyclerview)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter(this, menu)
        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(recycler)
    }
}