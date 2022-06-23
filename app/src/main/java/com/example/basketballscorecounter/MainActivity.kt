package com.example.basketballscorecounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.player_list.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val demoList = mutableListOf(
            PlayerList("Nishant", R.drawable.cross48px),
            PlayerList("Vinayak", R.drawable.cross48px),
            PlayerList("Devansh", R.drawable.cross48px),
            PlayerList("Yatem", R.drawable.cross48px))

        val adapter = PlayerAdapter(demoList)
        val recyclerView: RecyclerView = findViewById(R.id.recycleView)
        recyclerView.adapter= adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        addPlayer.setOnClickListener{
            val name = etPlayerName.text.toString()
            val newPlayer = PlayerList(name, R.drawable.cross48px)
            demoList.add(newPlayer)
            adapter.notifyItemInserted(demoList.size-1)
        }


    }
}