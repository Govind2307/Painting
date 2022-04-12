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
import kotlinx.coroutines.launch
import retrofit2.Response
import java.io.IOException
import java.lang.Exception

const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private  var adapter = Adapter()

    private val abcd = mutableListOf<DataItem>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerview.adapter=adapter
        var layoutManager = LinearLayoutManager(this)
        binding.recyclerview.layoutManager= layoutManager



        var service:UnsplashApi = UnsplashApi.create()
        lifecycleScope.launch {
            try {
                val response = service.getData("XSgz-lyCI_peixQ5kIwO5hMVJmBYJvNEigoMU2n1RF0",1)
                if(response.isSuccessful){
                    response.body()?.let {
                        val responseBody=response.body()
                        if(responseBody != null){
                            abcd.addAll(responseBody)
                        }
                        adapter.todos=abcd
                        adapter.notifyDataSetChanged()
                    }
                }
            }catch (e:Exception){
                Log.d(TAG,"Tumse ni hoga")
            }
        }


        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener{
            Toast.makeText(this,"Navigation",Toast.LENGTH_LONG).show()
        }
        binding.up.setOnClickListener{
            binding.recyclerview.smoothScrollToPosition(0)

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

        binding.recyclerview.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                binding.up.isVisible=layoutManager.findLastVisibleItemPosition()!=0
            }
        })
        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(binding.recyclerview)
    }
}