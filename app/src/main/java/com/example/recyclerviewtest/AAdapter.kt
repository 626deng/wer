package com.example.recyclerviewtest

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.time.LocalDate

class AAdapter(val list: List<App>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class LeftViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
    {
        val textView:TextView=itemView.findViewById(R.id.textView)
    }

    inner class RightViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
    {
        val textView2:TextView=itemView.findViewById(R.id.textView2)
    }

    override fun getItemViewType(position: Int): Int {
        val app=list[position]
        return app.type
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(viewType==0)
        {
            val view=LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
            return LeftViewHolder(view)
        }else{
            val view=LayoutInflater.from(parent.context).inflate(R.layout.item2,parent,false)
            return RightViewHolder(view)
        }
    }

    override fun getItemCount()=list.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val app=list[position]
        when(holder)
        {
            is LeftViewHolder->holder.textView.text=app.content
            is RightViewHolder->holder.textView2.text=app.content
            else -> throw IllegalAccessException()
        }
    }


}