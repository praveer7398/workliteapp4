package com.example.workliteapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.workliteapp.databinding.FragmentProfileBinding
import com.google.android.gms.common.util.CollectionUtils.listOf


class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    private lateinit var adapter: ProfileAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Sample data for ProfileItems
        val profileItems = listOf(
            ProfileItem("Sunita", "9015768567", R.drawable.person),
            ProfileItem("Sunita", "9015768567", R.drawable.person),
            ProfileItem("Sunita", "9015768567", R.drawable.person),
            ProfileItem("Naina", "9015768567", R.drawable.person),
            ProfileItem("Vineeta", "9015768567", R.drawable.person),
            ProfileItem("Sunita", "9015768567", R.drawable.person),
            ProfileItem("Sunita", "9015768567", R.drawable.person),
            // Add more ProfileItems as needed
        )

        // Initialize adapter with the provided data
        adapter = ProfileAdapter(requireContext(), profileItems)

        // Set layout manager and adapter for RecyclerView
        binding.cartRecycler.layoutManager = LinearLayoutManager(requireContext())
        binding.cartRecycler.adapter = adapter
    }
}