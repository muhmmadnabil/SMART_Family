package com.ahmed.smartfamily.ui.fragments.rank

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.ahmed.smartfamily.ui.fragments.base.BaseFragment
import com.ahmed.smartfamily.R
import com.ahmed.smartfamily.databinding.FragmentRankingBinding


class RankingFragment : BaseFragment<FragmentRankingBinding>() {
    private lateinit var navController: NavController
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentRankingBinding
        get() = FragmentRankingBinding::inflate

    override fun setupOnViewCreated(view: View) {
        navController = Navigation.findNavController(view)

        binding.rankingTvPresident.setOnClickListener {
            navController.navigate(R.id.action_rankingFragment_to_imagesFragment)
        }
    }
}