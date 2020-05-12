package com.example.sqlite_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val ct = this

    var list = mutableListOf<Int>()

    val this_adapter = Adapter(ct ,list)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initList()

        setUpRecyclerView()

        setAction()


    }

    fun initList(){

        for (i in 1..3){

            list.add(i)

        }

    }

    fun setAction(){

        add_btn.setOnClickListener {

            list.add(list.size+1)

            this_adapter.notifyDataSetChanged()

        }

    }


    fun setUpRecyclerView(){

        recyclerview.layoutManager = LinearLayoutManager(ct)

        recyclerview.adapter = this_adapter

        this_adapter.notifyDataSetChanged()
    }


}
