package com.example.workliteapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.workliteapp.Card.CardActivity1
import com.example.workliteapp.Card.CardActivity2
import com.example.workliteapp.Card.CardActivity3
import com.example.workliteapp.Card.CardActivity4
import com.example.workliteapp.databinding.FragmentCardBinding
import com.example.workliteapp.databinding.FragmentHomeBinding


class cardFragment : Fragment() {
    private lateinit var binding: FragmentCardBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCardBinding.inflate(inflater, container, false)

        //  retrieveDataFromFirestore()


        val intent = Intent(context, CardActivity1::class.java)
        startActivity(intent)


        binding.cardview4.setOnClickListener {
            val intent = Intent(context, CardActivity2::class.java)
            startActivity(intent)
        }

        binding.cardview5.setOnClickListener {
            val intent = Intent(context, CardActivity3::class.java)
            startActivity(intent)
        }

        binding.cardview6.setOnClickListener {
            val intent = Intent(context, CardActivity4::class.java)
            startActivity(intent)
        }
        return (binding.root)
    }
}


