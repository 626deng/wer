package com.example.recyclerviewtest

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.app.Fragment
import android.widget.EditText
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    val list=ArrayList<App>()
    lateinit var button:Button
    lateinit var recyclerView: RecyclerView
    lateinit var editText: EditText

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button=findViewById(R.id.button)
        recyclerView=findViewById(R.id.recyclerView)
        editText=findViewById(R.id.editText)
        initApp()
        val adapter=AAdapter(list)
        recyclerView.adapter=adapter
        recyclerView.layoutManager=LinearLayoutManager(this)
        button.setOnClickListener {
            val content=editText.text.toString()
            if(content.isNotEmpty())
            {
                val app=App(content, 0)
                list.add(app)
                adapter.notifyItemInserted(list.size-1)
                recyclerView.scrollToPosition(list.size-1)
                editText.setText("")
            }
        }
    }

    fun initApp()
    {
        val app1=App("This is content1",0)
        list.add(app1)

        val app2=App("This is content2",1)
        list.add(app2)

        val app4=App("this is content4",0)
        list.add(app4)

        val app5=App("this is content5",0)
        list.add(app5)

        val app3=App("this is content3",0)
        list.add(app3)
    }


}