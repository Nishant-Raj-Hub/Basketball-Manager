package com.example.basketballscorecounter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PlayerAdapter(val playerItems: List<PlayerList>):
    RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder>() {

    inner class PlayerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.player_list, parent, false)
        return PlayerViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        holder.itemView.apply {
            val player: TextView = findViewById(R.id.playerName)
            val cross: ImageView = findViewById(R.id.cross)
            player.text = playerItems[position].playerName
            cross.setImageResource(playerItems[position].crossImage)
            cross.setOnClickListener{

                playerItems.removeAt(position)
                notifyDataSetChanged()

            }
        }

    }

    override fun getItemCount(): Int {
        return playerItems.size
    }


}