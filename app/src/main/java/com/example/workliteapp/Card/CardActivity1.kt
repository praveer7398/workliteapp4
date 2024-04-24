package com.example.workliteapp.Card

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.example.workliteapp.R
import com.example.workliteapp.databinding.ActivityCard1Binding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase



class CardActivity1 : AppCompatActivity() {
    private lateinit var option: String
    private lateinit var binding: ActivityCard1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityCard1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val spinner = findViewById<Spinner>(R.id.spinnerGender)

        val cOptions = arrayOf("Please select your job type ","Chef", "Sweeper", "Nanny","Laundary","Gardener","Household")


        val adapter = ArrayAdapter(this, R.layout.spinner_item, cOptions)
        adapter.setDropDownViewResource(R.layout.dropdown_item)
        spinner.adapter = adapter
        spinner.setSelection(0)
        var isGenderSelected = false
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View?, position: Int, id: Long) {
                // Check if a valid selection (not the hint) is made
                if (position != 0) {
                    isGenderSelected = true
                    option = cOptions[position] // Capture the selected gender
                } else {
                    isGenderSelected = false
                    option = "" // Reset gender when nothing is selected
                }
            }
            override fun onNothingSelected(parentView: AdapterView<*>?) {
                Toast.makeText(this@CardActivity1, "Please select a category", Toast.LENGTH_SHORT).show()
            }
        }

        binding.submitButton.setOnClickListener {
            validateAndStoreData()
        }
    }

    private fun validateAndStoreData() {
        val Name = binding.fullNameEditText.text.toString()
        val address = binding.addressEditText.text.toString()
        val phone = binding.phoneEditText.text.toString()
        val charges = binding.registerPasswordEditText.text.toString()

        /* if (taskName.isEmpty()) {
             binding.taskame.requestFocus()
             binding.taskame.error = "Task Name cannot be empty"
             return
         }

         if (taskDate.isEmpty()) {
             binding.taskdate.requestFocus()
             binding.taskdate.error = "Task Date cannot be empty"
             return
         }*/



        storeData(Name,address,phone,charges)
    }

    private fun storeData(Name: String, address: String, phone: String, charges: String ) {
        val db = Firebase.firestore

        val productsRef = db.collection("Jobs")



        val data = addCardModel(binding.fullNameEditText.toString(),
            binding.addressEditText.toString(),
            binding.phoneEditText.toString(),
            binding.registerPasswordEditText.toString(),


        )



        productsRef.add(data)
            .addOnSuccessListener {
                Toast.makeText(this@CardActivity1, "Successfully", Toast.LENGTH_SHORT).show()
                clearFields()
            }
            .addOnFailureListener { e ->
                Log.e("FirebaseError", "Error adding product", e)
                Toast.makeText(
                    this@CardActivity1,
                    "Something went wrong: ${e.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }
    }

    private fun clearFields() {
        binding.fullNameEditText.text = null
        binding.addressEditText.text = null
        binding.phoneEditText.text = null
        binding.registerPasswordEditText.text = null
    }
}

