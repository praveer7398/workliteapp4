package com.example.workliteapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.common.util.CollectionUtils.listOf


class PayFragment : Fragment() {
    private val workList = listOf(
        WorkEntry("2024-04-25", "09:00 AM", "Project A", "$100"),
        WorkEntry("2024-04-26", "10:00 AM", "Project B", "$120"),
        WorkEntry("2024-04-27", "11:00 AM", "Project C", "$150")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_pay, container, false)

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        val adapter = WorkAdapter(workList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        return view
    }
}