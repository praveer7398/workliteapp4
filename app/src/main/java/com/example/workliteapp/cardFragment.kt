package com.example.workliteapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        binding=FragmentCardBinding.inflate(layoutInflater)
        return (binding.root)
    }


    }
