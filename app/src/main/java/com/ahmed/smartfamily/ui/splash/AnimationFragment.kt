package com.ahmed.smartfamily.ui.splash

import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.ahmed.smartfamily.BaseFragment
import com.ahmed.smartfamily.R
import com.ahmed.smartfamily.databinding.FragmentAnimationBinding

class AnimationFragment : BaseFragment<FragmentAnimationBinding>() {

    private lateinit var navController: NavController
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentAnimationBinding
        get() = FragmentAnimationBinding::inflate

    override fun setupOnViewCreated(view: View) {
        navController = Navigation.findNavController(view)

        animation()
    }

    private fun animation() {
        //ImageView Animation
        Handler().postDelayed({
            val animation = AnimationUtils.loadAnimation(context, R.anim.blink)
            binding.animationIvSmart.startAnimation(animation)
        }, 2000)


        //TextView Animation
        //Typing Animation
        Handler().postDelayed({
            run {
                binding.animationTv.visibility = View.VISIBLE
                binding.animationTv.text = "A"
            }
        }, 1400)
        Handler().postDelayed({
            run {
                binding.animationTv.append("c")
            }
        }, 1600)
        Handler().postDelayed({
            run {
                binding.animationTv.append("t")
            }
        }, 1800)
        Handler().postDelayed({
            run {
                binding.animationTv.append("i")
            }
        }, 2000)
        Handler().postDelayed({
            run {
                binding.animationTv.append("v")
            }
        }, 2200)
        Handler().postDelayed({
            run {
                binding.animationTv.append("a")
            }
        }, 2400)
        Handler().postDelayed({
            run {
                binding.animationTv.append("t")
            }
        }, 2600)
        Handler().postDelayed({
            run {
                binding.animationTv.append("e")
            }
        }, 2800)
        Handler().postDelayed({
            run {
                binding.animationTv.append(" ")
            }
        }, 3000)
        Handler().postDelayed({
            run {
                binding.animationTv.append("Y")
            }
        }, 3200)
        Handler().postDelayed({
            run {
                binding.animationTv.append("o")
            }
        }, 3400)
        Handler().postDelayed({
            run {
                binding.animationTv.append("u")
            }
        }, 3600)
        Handler().postDelayed({
            run {
                binding.animationTv.append("r")
            }
        }, 3800)
        Handler().postDelayed({
            run {
                binding.animationTv.append(" ")
            }
        }, 4000)
        Handler().postDelayed({
            run {
                binding.animationTv.append("M")
            }
        }, 4200)
        Handler().postDelayed({
            run {
                binding.animationTv.append("i")
            }
        }, 4400)
        Handler().postDelayed({
            run {
                binding.animationTv.append("n")
            }
        }, 4600)
        Handler().postDelayed({
            run {
                binding.animationTv.append("d")
            }
        }, 4800)

        Handler().postDelayed({
            navController.navigate(R.id.action_animationFragment_to_rankingFragment)
        }, 5000)

    }
}