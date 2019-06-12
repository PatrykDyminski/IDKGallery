package com.example.idkgallery

import android.os.Bundle
import android.support.wearable.activity.WearableActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : WearableActivity() {

    private val photos: ArrayList<Int> = ArrayList()
    var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        photos.add(R.drawable.photo1)
        photos.add(R.drawable.photo2)
        photos.add(R.drawable.photo3)

        // Enables Always-on
        setAmbientEnabled()

        buttonL.setOnClickListener { left() }
        buttonR.setOnClickListener { right() }
    }

    private fun right() {
        val nextIndex = index +1
        if(nextIndex<photos.size){
            myLayout.setBackgroundResource(photos[nextIndex])
            index = nextIndex
        }else{
            myLayout.setBackgroundResource(photos[0])
            index = 0
        }
    }

    private fun left() {
        val prevIndex = index - 1
        if(!(prevIndex<0)){
            myLayout.setBackgroundResource(photos[prevIndex])
            index = prevIndex
        }else{
            myLayout.setBackgroundResource(photos[photos.size - 1])
            index = photos.size-1
        }

    }

}
