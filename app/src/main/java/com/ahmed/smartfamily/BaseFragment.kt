package com.ahmed.smartfamily

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.viewbinding.ViewBinding


abstract class BaseFragment<T : ViewBinding> : Fragment() {
    //Binding View
    private var _binding: ViewBinding? = null
    abstract val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> T
    private var _navController: NavController? = null

    //this will be used in child classes
    protected val binding: T
        get() = _binding as T

    lateinit var mDialog: Dialog

    fun showProgressDialog(context: Context) {
        mDialog = Dialog(context)
        mDialog.setContentView(R.layout.fragment_base)
        mDialog.show()
    }

    fun hideProgressDialog() {
        mDialog.dismiss()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = bindingInflater.invoke(inflater, container, false)
        return _binding!!.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupOnViewCreated(view)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


    //Implemented into the child class
    abstract fun setupOnViewCreated(view: View)


}