package com.example.workliteapp

/*import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.widget.EditText
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase
import java.util.ArrayList

class activity_chat : AppCompatActivity() {
 private lateinit var chatRecyclerView: RecyclerView
    private lateinit var auth :FirebaseAuth
  private lateinit var messageBox: EditText
  private lateinit var sendButton: ImageView
  //private lateinit var msgadapter: msgadapter
  private lateinit var msgAdapter: msgadapter
  private lateinit var messageList: ArrayList<Message>
  private lateinit var mDbRef: DatabaseReference
  var rroom: String?=null
    var sroom: String?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_chat)

        val name = intent.getStringExtra("name")
        val ruid = intent.getStringExtra("uid")
         val suid = auth.currentUser?.uid
        mDbRef = FirebaseDatabase.getInstance().getReference()
        sroom = ruid + suid
        rroom = suid + ruid
        chatRecyclerView = findViewById(R.id.chatRecyclerView)
        messageBox = findViewById(R.id.etMessage)
        sendButton = findViewById(R.id.btnSendMessage)
        messageList = ArrayList()
     //   Msgadapter = msgadapter(this,messageList)
     //   msgAdapter = msgadapter(this, messageList)
        sendButton.setOnClickListener{
            val message = messageBox.text.toString()
            val messageO = Message(message,suid!!)
            mDbRef.child("chats").child(sroom!!).child("message").push()
                .setValue(messageO)
                .addOnSuccessListener {
                    mDbRef.child("chats").child(rroom!!).child("message").push()
                        .setValue(messageO)
                }

        }
    }
}*/


/*    private lateinit var chatRecyclerView: RecyclerView
    private lateinit var auth: FirebaseAuth
    private lateinit var messageBox: EditText
    private lateinit var sendButton: ImageView
    private lateinit var msgAdapter: msgadapter

    private lateinit var messageList: ArrayList<Message>
    private lateinit var mDbRef: DatabaseReference
    private var rroom: String? = null
    private var sroom: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)


        val name = intent.getStringExtra("name")
        val ruid = intent.getStringExtra("uid")
        val suid = auth.currentUser?.uid
        mDbRef = FirebaseDatabase.getInstance().reference
        sroom = ruid + suid
        rroom = suid + ruid
        chatRecyclerView = findViewById(R.id.chatRecyclerView)
        messageBox = findViewById(R.id.etMessage)
        sendButton = findViewById(R.id.btnSendMessage)
        messageList = ArrayList()
        msgAdapter = msgadapter(this, messageList)
        chatRecyclerView.adapter = msgAdapter

        sendButton.setOnClickListener {
            val message = messageBox.text.toString()
            val messageO = Message(message, suid!!)
            mDbRef.child("chats").child(sroom!!).child("message").push()
                .setValue(messageO)
                .addOnSuccessListener {
                    mDbRef.child("chats").child(rroom!!).child("message").push()
                        .setValue(messageO)
                }
        }
    }
}*/

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import java.util.*


class activity_chat : AppCompatActivity() {

    private lateinit var chatRecyclerView: RecyclerView
    private lateinit var auth: FirebaseAuth
    private lateinit var messageBox: EditText
    private lateinit var sendButton: ImageView
    private lateinit var msgAdapter: msgadapter
    private lateinit var messageList: ArrayList<Message>
    private lateinit var mDbRef: DatabaseReference
    private var rroom: String? = null
    private var sroom: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        auth = FirebaseAuth.getInstance()
        val name = intent.getStringExtra("name")
        val ruid = intent.getStringExtra("uid")
        val suid = auth.currentUser?.uid
        mDbRef = FirebaseDatabase.getInstance().getReference()
        sroom = ruid + suid
        rroom = suid + ruid
        chatRecyclerView = findViewById(R.id.chatRecyclerView)
        messageBox = findViewById(R.id.etMessage)
        sendButton = findViewById(R.id.btnSendMessage)
        messageList = ArrayList()
        msgAdapter = msgadapter(this, messageList)
        chatRecyclerView.adapter = msgAdapter

     /*   // Listen for new messages in the database
        mDbRef.child("chats").child(sroom!!).child("message")
            .addChildEventListener(object : ChildEventListener {
                override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
                    val message = snapshot.getValue(Message::class.java)
                    if (message != null) {
                        messageList.add(message)
                        msgAdapter.notifyDataSetChanged()
                    }
                }

                override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {}

                override fun onChildRemoved(snapshot: DataSnapshot) {}

                override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {}

                override fun onCancelled(error: DatabaseError) {}
            })

        sendButton.setOnClickListener {
            val message = messageBox.text.toString()
            val messageO = Message(message, suid!!)
            mDbRef.child("chats").child(sroom!!).child("message").push()
                .setValue(messageO)
                .addOnSuccessListener {
                    mDbRef.child("chats").child(rroom!!).child("message").push()
                        .setValue(messageO)
                }
        }
    }
}*/
        sendButton.setOnClickListener{
            val message = messageBox.text.toString()
            val messageO = Message(message,suid!!)
            mDbRef.child("chats").child(sroom!!).child("message").push()
                .setValue(messageO)
                .addOnSuccessListener {
                    mDbRef.child("chats").child(rroom!!).child("message").push()
                        .setValue(messageO)
                }

        }
    }
}



