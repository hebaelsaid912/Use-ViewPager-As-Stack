package com.example.testviewpagerasstack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rv:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv = findViewById(R.id.rv1)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        rv.layoutManager = layoutManager
        val adapter = RecycleAdapter()
        adapter.setData(listOf("a","b","c","d","e","f","g","h","i","j","k"))
        rv.adapter = adapter
    }
}