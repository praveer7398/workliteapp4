package com.example.workliteapp


import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.workliteapp.databinding.LayoutProfileItemBinding
import com.example.workliteapp.databinding.TaskLayoutitemBinding

class taskAdapter(private val context: Context, private val list: List<TaskItem>) :
    RecyclerView.Adapter<taskAdapter.CartViewHolder>() {

    inner class CartViewHolder(val binding: TaskLayoutitemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = TaskLayoutitemBinding.inflate(LayoutInflater.from(context), parent, false)
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val currentItem = list[position]
        holder.binding.task1.text = currentItem.taskName
        holder.binding.taskDueDate1.text = currentItem.taskdate


    }

    override fun getItemCount(): Int {
        return list.size
    }

}
