package com.example.sqlite_test

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.itemview.view.*

class Adapter(var ct:Context,var outerList: MutableList<Int>) : RecyclerView.Adapter<Adapter.ViewHolder>(){

    var innerList = mutableListOf<Int>()


    init {

        innerList = outerList

    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {


        val view = LayoutInflater.from(ct).inflate(R.layout.itemview,parent,false)

        return ViewHolder(view)

    }

    override fun getItemCount(): Int = innerList.size

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {

        holder.setUI(position)

    }

    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view){

        val num_text = view.num_text

        fun setUI(position: Int){

            num_text.text = innerList[position].toString()

        }

    }

    fun update (list: MutableList<Int>){

        innerList = list

        notifyDataSetChanged()

    }
}