package com.ahmed.smartfamily.ui.member

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.ahmed.smartfamily.BaseFragment
import com.ahmed.smartfamily.data.model.Members
import com.ahmed.smartfamily.databinding.FragmentMemberBinding
import com.ahmed.smartfamily.utils.CheckInternetConnection


class MemberFragment : BaseFragment<FragmentMemberBinding>(), MemberListener {

    private lateinit var navController: NavController
    private lateinit var viewModel: MemberViewModel
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentMemberBinding
        get() = FragmentMemberBinding::inflate

    override fun setupOnViewCreated(view: View) {
        navController = Navigation.findNavController(view)
        viewModel = ViewModelProvider(this).get(MemberViewModel::class.java)
        viewModel.memberListener = this
        val token = arguments?.getString("token")
        viewModel.getMembers(token!!.toInt())
    }

    override fun onStarted() {
        showProgressDialog(requireContext())
    }

    override fun onSuccess(member: Members) {
        hideProgressDialog()
        binding.tvName.text = member.name
        binding.tvEmail.text = member.email
        binding.tvNumber.text = member.phone
    }

    override fun onFailure(msg: String) {
        Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
    }

    override fun onConnection(): Boolean {
        return CheckInternetConnection(requireContext()).isConnection()
    }
}