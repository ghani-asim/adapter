package com.example.kotlinadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainListView.adapter = MyCustomAdapter(this, GlobalModel.presidents)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)


        mainListView.setOnItemClickListener { _, _, position, _ ->
            val name = GlobalModel.presidents[position].name

            detailView.text = GlobalModel.presidents[position].toString()

            viewModel.hits(name).observe(this, Observer {
                textView.text = "${getString(R.string.total_hits)} ${it.query.searchinfo.totalhits}"
            })
        }
    }
}