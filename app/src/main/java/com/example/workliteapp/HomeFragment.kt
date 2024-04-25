package com.example.workliteapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.workliteapp.databinding.FragmentHomeBinding
import com.google.android.gms.common.util.CollectionUtils
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.util.*


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: taskAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)

        //    getProducts()
        retrieveDataFromFirestore()
        return binding.root

    }




    private fun retrieveDataFromFirestore() {
        val db = Firebase.firestore
        val productsRef = db.collection("Products")

        val taskItemList = mutableListOf<TaskItem>() // Step 1: Create an empty list

        productsRef.get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    // Step 2: Create TaskItem objects and add them to the list
                    val taskName = document.getString("taskName") ?: ""
                    val taskDate = document.getString("taskdate") ?: ""
                    val taskItem = TaskItem(taskName, taskDate)
                    taskItemList.add(taskItem)

                    // Example: Display data in Logcat
                    Log.d(
                        "FirestoreData",
                        "Task Name: $taskName, Task Date: $taskDate",
                    )
                }

                // Step 3: Initialize RecyclerView adapter with the list and set it to RecyclerView
                adapter = taskAdapter(requireContext(), taskItemList)
                binding.cartRecycler.adapter = adapter
                binding.cartRecycler.layoutManager = LinearLayoutManager(requireContext())
            }
            .addOnFailureListener { e ->
                Log.e("FirestoreError", "Error retrieving data", e)
                Toast.makeText(
                    requireContext(),
                    "Error retrieving data: ${e.message}",
                    Toast.LENGTH_SHORT
                )
                    .show()
            }
    }
}



