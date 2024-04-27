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
        WorkEntry("2024-04-28", "09:00 AM", "Outdoor Cleaning", "5:00 PM"),
        WorkEntry("2024-04-27", "10:00 AM", "Cleaning Restrooms", "4:00 PM"),
        WorkEntry("2024-04-26", "11:00 AM", "Sweeping floor", "3:30 PM"),
        WorkEntry("2024-04-25", "10:00 AM", "Meal Preparation", "6:00 PM"),
        WorkEntry("2024-04-24","11:00 AM", "Laundary", "4:30 PM"),
        WorkEntry("2024-04-23","12:00 PM","Watering","6:00 PM"),
        WorkEntry("2024-04-22","1:00 PM","Garbage disposal","6:00 PM"),
        WorkEntry("2024-04-21","5:00 PM","Cleaning","5:00 AM"),
        WorkEntry("2024-04-20","5:00 PM","Outdoor Cleaning","4 AM",),
        WorkEntry("2024-04-19", "09:00 AM", "Laundary", "4:00 AM"),
        WorkEntry("2024-04-18", "11:00 AM", "Sweeping floor", "6:00 PM"),
        WorkEntry("2024-04-17", "10:00 AM", "Outdoor Cleaning", "2:00 PM"),
        WorkEntry("2024-04-16","11:00 AM", "Meal Preparation", "4:15 PM"),
        WorkEntry("2024-04-15","4:00 PM","Laundary","6:00 AM"),
        WorkEntry("2024-04-14","3:00 PM","Sweeping floor","6:00 AM",),
        WorkEntry("2024-04-13", "09:00 AM", "Outdoor Cleaning", "5:00 PM"),
        WorkEntry("2024-04-12", "10:00 AM", "Meal Preparation", "5:30 PM"),
        WorkEntry("2024-04-11","11:00 AM", "Laundary", "5:00 PM"),
        WorkEntry("2024-04-10","12:00 PM","Sweeping floor","6:18"),
        WorkEntry("2024-04-09","1:00 PM","Meal Preparation","5:00 PM"),
        WorkEntry("2024-04-08","4:00 PM","Outdoor Cleaning","6:00 AM"),


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