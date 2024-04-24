package com.example.workliteapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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

        getProducts()
        // retrieveDataFromFirestore()
        return binding.root

    }

    // Call method to retrieve data


    /*   private fun retrieveDataFromFirestore() {
        val db = Firebase.firestore
        val productsRef = db.collection("Products")

        productsRef.get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    // Access document fields and show in UI or process as needed
                    val taskName = document.getString("taskName")
                    val taskDate = document.getString("taskDate")


                    // Example: Display data in Logcat
                    Log.d(
                        "FirestoreData",
                        "Task Name: $taskName, Task Date: $taskDate",
                    )

                    // Example: Display data in Toast
                    Toast.makeText(
                        requireContext(),
                        "Task Name: $taskName, Task Date: $taskDate",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            .addOnFailureListener { e ->
                Log.e("FirestoreError", "Error retrieving data", e)
                Toast.makeText(requireContext(), "Error retrieving data: ${e.message}", Toast.LENGTH_SHORT)
                    .show()
            }
    }
}*/

    /*  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val profileItems = CollectionUtils.listOf(

            TaskItem("Mala", "7392659120"),
            TaskItem("Mala", "7392659120"),
            TaskItem("Mala", "7392659120"),
            TaskItem("Mala", "7392659120"),
            TaskItem("Mala", "7392659120"),
            TaskItem("Mala", "7392659120"),

            // Add more ProfileItems as needed
        )

        // Initialize adapter with the provided data
        adapter = taskAdapter(requireContext(), profileItems)

        // Set layout manager and adapter for RecyclerView
        binding.cartRecycler.layoutManager = LinearLayoutManager(requireContext())
        binding.cartRecycler.adapter = adapter
    }
}*/


    private fun getProducts() {
        val list = ArrayList<TaskItem>()
        Firebase.firestore.collection("Products")
            .get().addOnSuccessListener {
                list.clear()
                for (doc in it.documents) {
                    val data = doc.toObject(TaskItem::class.java)
                    list.add(data!!)
                }
                binding.cartRecycler.adapter = taskAdapter(requireContext(), list)
            }
    }
}

