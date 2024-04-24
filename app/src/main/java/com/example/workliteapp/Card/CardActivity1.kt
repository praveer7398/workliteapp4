package com.example.workliteapp.Card

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.example.workliteapp.R

class CardActivity1 : AppCompatActivity() {
    private lateinit var option: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card1)

        val spinner = findViewById<Spinner>(R.id.spinnerGender)

        val cOptions = arrayOf("Pleae select your job ","Chef", "Sweeper", "Nanny","Laundary","Gardener","Household")


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
    }
}