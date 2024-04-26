package com.example.workliteapp

import android.content.BroadcastReceiver
//
//data class ChatType
//    (var senderId: String="", var receiverId: String = "", var message: String = "")
//{
//        constructor(): this("","","",)
//    }
data class ChatType(var message: String,
                    var UID:String)

{
    constructor():this("","")
}