package com.example.workliteapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.workliteapp.databinding.FragmentHomeBinding
import com.example.workliteapp.databinding.FragmentProfileBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.util.*


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

            retrieveDataFromFirestore()

        return binding.root

    }

    // Call method to retrieve data


    private fun retrieveDataFromFirestore() {
        val db = Firebase.firestore
        val productsRef = db.collection("Products")

        productsRef.get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    // Access document fields and show in UI or process as needed
                    val taskName = document.getString("taskName")
                    val taskDate = document.getString("taskDate")
                    val checkIn = document.getString("checkIn")
                    val checkOut = document.getString("checkOut")

                    // Example: Display data in Logcat
                    Log.d(
                        "FirestoreData",
                        "Task Name: $taskName, Task Date: $taskDate, Check In: $checkIn, Check Out: $checkOut"
                    )

                    // Example: Display data in Toast
                    Toast.makeText(
                        requireContext(),
                        "Task Name: $taskName, Task Date: $taskDate, Check In: $checkIn, Check Out: $checkOut",
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
}



