package com.example.workliteapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CardAdapter(private val itemList: List<CardItem>) :
    RecyclerView.Adapter<CardAdapter.CardViewHolder>() {

    class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewDate: TextView = itemView.findViewById(R.id.textViewDate)
        val textViewTime: TextView = itemView.findViewById(R.id.textViewTime)
        val textViewWork: TextView = itemView.findViewById(R.id.textViewWork)
        val textViewWages: TextView = itemView.findViewById(R.id.textViewWages)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_item, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val currentItem = itemList[position]
        holder.textViewDate.text = "Date: ${currentItem.date}"
        holder.textViewTime.text = "Time: ${currentItem.time}"
        holder.textViewWork.text = "Work: ${currentItem.work}"
        holder.textViewWages.text = "Wages: ${currentItem.wages}"
    }

    override fun getItemCount() = itemList.size
}
