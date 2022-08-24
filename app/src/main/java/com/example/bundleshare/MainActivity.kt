package com.example.bundleshare

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentOne = FragmentOne()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_holder, fragmentOne)
            commit()
        }
    }
}