package com.example.routemap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun moveNext(view: android.view.View) {
        intent = Intent(applicationContext, MapsActivity::class.java)
        startActivity(intent)
    }
}