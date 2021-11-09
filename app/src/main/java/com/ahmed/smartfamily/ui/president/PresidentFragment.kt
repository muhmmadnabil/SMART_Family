package com.ahmed.smartfamily.ui.president

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.ahmed.smartfamily.BaseFragment
import com.ahmed.smartfamily.MainActivity
import com.ahmed.smartfamily.databinding.FragmentPresidentBinding


class PresidentFragment : BaseFragment<FragmentPresidentBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentPresidentBinding
        get() = FragmentPresidentBinding::inflate
    private lateinit var navController: NavController
    override fun setupOnViewCreated(view: View) {
        navController = Navigation.findNavController(view)

    }


}