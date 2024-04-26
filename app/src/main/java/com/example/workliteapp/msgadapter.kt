package com.example.workliteapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import java.util.ArrayList

class msgadapter(val context: Context, val messagelist:ArrayList<Message>) :RecyclerView.Adapter<RecyclerView.ViewHolder> (){
    val Item_Receive=1
    val Item_Sent=2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(viewType==1){
            val view:View = LayoutInflater.from(context).inflate(R.layout.received, parent, false)
            return ReceiveViewHolder(view)
        }else{
            val view:View = LayoutInflater.from(context).inflate(R.layout.sent, parent, false)
            return SentViewHolder(view)
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val currentmsg=messagelist[position]
       if(holder.javaClass == SentViewHolder::class.java){

           val viewHolder=holder as SentViewHolder
           holder.sentmsg.text= currentmsg.message

       }else{
           val viewHolder=holder as ReceiveViewHolder
           holder.receivemsg.text=currentmsg.message
       }
    }

    override fun getItemViewType(position: Int): Int {
        var currentmsg= messagelist[position]
        if(FirebaseAuth.getInstance().currentUser?.uid.equals(currentmsg.senderID)) {
            return  Item_Sent
        }else{
            return Item_Receive
        }
    }

    override fun getItemCount(): Int {
        return  messagelist.size

    }
    class SentViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val sentmsg=itemView.findViewById<TextView>(R.id.sent_msg)

    }
    class ReceiveViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val receivemsg=itemView.findViewById<TextView>(R.id.receive_msg)

    }

}
