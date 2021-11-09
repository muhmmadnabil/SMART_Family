package com.ahmed.smartfamily

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ahmed.smartfamily.databinding.FragmentEventsBinding

class EventsFragment : BaseFragment<FragmentEventsBinding>() {

    var myArray=ArrayList<Int>()

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentEventsBinding
        get() = FragmentEventsBinding::inflate

    override fun setupOnViewCreated(view: View) {

        binding.recyclerView.layoutManager=LinearLayoutManager(context,RecyclerView.VERTICAL,false)
        myArray.add(R.drawable.event_1)
        myArray.add(R.drawable.event_1)
        myArray.add(R.drawable.event_1)
        myArray.add(R.drawable.event_1)
        myArray.add(R.drawable.event_1)
        myArray.add(R.drawable.event_1)
        myArray.add(R.drawable.event_1)
        myArray.add(R.drawable.event_1)
        myArray.add(R.drawable.event_1)
        myArray.add(R.drawable.event_1)
        val myAdapter=CustomAdapter(myArray)
        binding.recyclerView.adapter=myAdapter
    }
}