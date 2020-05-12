package com.example.sqlite_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val ct = this

    var list = mutableListOf<Int>()

    val this_adapter = Adapter(ct ,list)

    // new

    lateinit var itemTouchHelper: ItemTouchHelper

    // new

    lateinit var callback: ItemTouchHelper.Callback

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initList()

        // new

        initItemTouchHelper()

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

        // new

        itemTouchHelper.attachToRecyclerView(recyclerview)

        this_adapter.notifyDataSetChanged()
    }

    // new

    fun initItemTouchHelper(){

        callback = object :ItemTouchHelper.Callback(){


            override fun onSelectedChanged(viewHolder: RecyclerView.ViewHolder?, actionState: Int) {


            }

            override fun isItemViewSwipeEnabled(): Boolean {


                return true


            }


            override fun isLongPressDragEnabled(): Boolean {


                return true


            }

            override fun getMovementFlags(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder
            ): Int {

                val dragFlags = ItemTouchHelper.UP or ItemTouchHelper.DOWN

                val swipeFlags = ItemTouchHelper.START or ItemTouchHelper.END

                return makeMovementFlags(dragFlags,swipeFlags)
            }

            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {

                 val fromPos = viewHolder.getAdapterPosition()

                 val toPos = target.getAdapterPosition()

                 this_adapter.moveItem(fromPos,toPos)

                return false  // true if moved, false otherwise
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.getAdapterPosition();

                this_adapter.removeItem(position)

            }


        }

        itemTouchHelper = object : ItemTouchHelper(callback){



        }




    }


}
