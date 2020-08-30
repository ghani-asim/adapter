package com.example.kotlinadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainListView.adapter = MyCustomAdapter(this, GlobalModel.presidents)

        mainListView.setOnItemClickListener { _, _, position, _ ->
            Log.d("USR","Selected $position")
            detailView.text = GlobalModel.presidents[position].toString()
        }
    }
}