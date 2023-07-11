package com.example.multiplerecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.multiplerecyclerview.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {


    private val adapterList by lazy {
        Adapter()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val  binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val itemList = DataBase.getItens()
        adapterList.updateList(itemList)
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity,LinearLayoutManager.VERTICAL,false)
            adapter = adapterList
        }
    }
}