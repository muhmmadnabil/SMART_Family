package com.ahmed.smartfamily.ui.qr

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.ahmed.smartfamily.BaseFragment
import com.ahmed.smartfamily.R
import com.ahmed.smartfamily.databinding.FragmentQrBinding
import com.budiyev.android.codescanner.*

class QRFragment : BaseFragment<FragmentQrBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentQrBinding
        get() = FragmentQrBinding::inflate
    private lateinit var navController: NavController
    private lateinit var codeScanner: CodeScanner
    override fun setupOnViewCreated(view: View) {
        navController = Navigation.findNavController(view)
        ActivityCompat.requestPermissions(
            requireActivity(),
            arrayOf(android.Manifest.permission.CAMERA),
            1
        )
        initQRScanner()


    }

    private fun initQRScanner() {
        val scannerView = binding.scannerView

        codeScanner = CodeScanner(requireContext(), scannerView)

        // Parameters (default values)
        codeScanner.camera = CodeScanner.CAMERA_BACK // or CAMERA_FRONT or specific camera id
        codeScanner.formats = CodeScanner.ALL_FORMATS // list of type BarcodeFormat,
        // ex. listOf(BarcodeFormat.QR_CODE)
        codeScanner.autoFocusMode = AutoFocusMode.CONTINUOUS // or CONTINUOUS
        codeScanner.scanMode = ScanMode.SINGLE // or CONTINUOUS or PREVIEW
        codeScanner.isAutoFocusEnabled = true // Whether to enable auto focus or not
        codeScanner.isFlashEnabled = false // Whether to enable flash or not

        // Callbacks
        codeScanner.decodeCallback = DecodeCallback {
            requireActivity().runOnUiThread {
                val bundle = bundleOf("token" to it.text.toString())
                navController.navigate(R.id.action_QRFragment_to_memberFragment, bundle)
            }

        }
        codeScanner.errorCallback = ErrorCallback { // or ErrorCallback.SUPPRESS

        }

        scannerView.setOnClickListener {
            codeScanner.startPreview()
        }

    }

    override fun onResume() {
        super.onResume()
        codeScanner.startPreview()
    }

    override fun onPause() {
        codeScanner.releaseResources()
        super.onPause()
    }

}