    package com.example.painting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView

    class MainActivity : AppCompatActivity() {

    lateinit var recycler: RecyclerView
    var menu : List<menu> = listOf(
        menu("https://surface678.com/wp-content/uploads/elementor/thumbs/edited_wake_tech-ovagsl83z9l43ggkcb0jjyd5vo1na0fp5ta32k5qwg.jpg","Leonardo","popular","writer"),
        menu("https://surface678.com/wp-content/uploads/elementor/thumbs/edited_wake_tech-ovagsl83z9l43ggkcb0jjyd5vo1na0fp5ta32k5qwg.jpg","Leonardo","popular","writer"),
        menu("https://surface678.com/wp-content/uploads/elementor/thumbs/edited_wake_tech-ovagsl83z9l43ggkcb0jjyd5vo1na0fp5ta32k5qwg.jpg","Leonardo","popular","writer"),
        menu("https://surface678.com/wp-content/uploads/elementor/thumbs/edited_wake_tech-ovagsl83z9l43ggkcb0jjyd5vo1na0fp5ta32k5qwg.jpg","Leonardo","popular","writer"))



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        view();

    }

        private fun view() {

            val snapHelper = PagerSnapHelper()
            snapHelper.attachToRecyclerView(recycler)
            val adapter = adapter(context = MainActivity(),menu)



            recycler = findViewById(R.id.RecyclerView)
            recycler.layoutManager = LinearLayoutManager(this)
            recycler.adapter = adapter(this,menu)
        }
    }