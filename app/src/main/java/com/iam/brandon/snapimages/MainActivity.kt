package com.iam.brandon.snapimages

import android.app.Activity
import android.graphics.Bitmap
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.widget.Adapter

class MainActivity : Activity() , MyCallback {
    val bmArray = mutableListOf<Bitmap>()

    var viewAdapter: CardAdapter? = null
    private lateinit var recyclerView: RecyclerView
    override fun handleBitmap(bm: Bitmap) {
        bmArray.add(bm)
        viewAdapter!!.notifyDataSetChanged()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val asyncThing = NetworkManager(this)

        asyncThing.getImages()

        viewAdapter = CardAdapter(bmArray)

        recyclerView = findViewById<RecyclerView>(R.id.myRecycleView).apply {
            setHasFixedSize(true)
            adapter = viewAdapter
        }
    }
}
