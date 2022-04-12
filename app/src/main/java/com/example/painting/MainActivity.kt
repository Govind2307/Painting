package com.example.painting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageButton
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.AdapterListUpdateCallback
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.painting.databinding.ActivityMainBinding
import com.example.painting.datafiles.DataItem
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException

const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter:Adapter
    lateinit var up:ImageButton
    lateinit var recycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        lifecycleScope.launchWhenCreated {
            val response = try {
                RetrofitInstance.api.getData("XSgz-lyCI_peixQ5kIwO5hMVJmBYJvNEigoMU2n1RF",1)
            }catch (e: IOException){
                Log.e(TAG,"IO Exception")
                return@launchWhenCreated
            }
            if (response.isSuccessful && response.body() != null){
                 (response.body() as MutableList<DataItem>?)!!
            }else{
                Log.e(TAG,"Response not successful")
            }
        }


        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener{
            Toast.makeText(this,"Navigation",Toast.LENGTH_LONG).show()
        }
        up = findViewById(R.id.up)
        up.setOnClickListener{
            recycler.smoothScrollToPosition(0)

    }
        initView();

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.mainmenu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var itemview = item.itemId
        when(itemview){
            R.id.search -> Toast.makeText(applicationContext,"Search",Toast.LENGTH_LONG).show()
            R.id.menu -> Toast.makeText(applicationContext,"menu",Toast.LENGTH_LONG).show()
        }
        return false
    }

    fun setupRecyclerView() = binding.recyclerview.apply {
        adapter = Adapter()
        adapter= adapter
        layoutManager = LinearLayoutManager(this@MainActivity)

    }


    private fun initView() {

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