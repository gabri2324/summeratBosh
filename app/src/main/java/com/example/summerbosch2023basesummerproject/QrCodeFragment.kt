package com.example.summerbosch2023basesummerproject

import android.app.Activity
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.budiyev.android.codescanner.AutoFocusMode
import com.budiyev.android.codescanner.CodeScanner
import com.budiyev.android.codescanner.CodeScannerView
import com.budiyev.android.codescanner.DecodeCallback
import com.budiyev.android.codescanner.ErrorCallback
import com.budiyev.android.codescanner.ScanMode
import com.example.summerbosch2023basesummerproject.databinding.FragmentQrCodeBinding
import com.squareup.picasso.Picasso


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [QrCodeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class QrCodeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var _binding: FragmentQrCodeBinding? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentQrCodeBinding.inflate(inflater, container, false)
        return _binding!!.root;
    }

    private lateinit var codescanner: CodeScanner

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (ContextCompat.checkSelfPermission(
                requireContext(),
                android.Manifest.permission.CAMERA
            ) ==
            PackageManager.PERMISSION_DENIED
        ) {
            ActivityCompat.requestPermissions(
                requireContext() as Activity,
                arrayOf(android.Manifest.permission.CAMERA),
                123
            )
        } else {
            startScanning()
        }
        _binding!!.pokemonButton.setOnClickListener {
            view?.findNavController()?.navigate(com.example.summerbosch2023basesummerproject.R.id.action_qrCodeFragment_to_pokemonFragment)
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun startScanning() {
        var scannerView: CodeScannerView = _binding!!.scannerView
        var result: String
        codescanner = CodeScanner(requireContext(), scannerView)
        codescanner.camera = CodeScanner.CAMERA_BACK
        codescanner.formats = CodeScanner.ALL_FORMATS

        codescanner.autoFocusMode = AutoFocusMode.SAFE
        codescanner.scanMode = ScanMode.SINGLE
        codescanner.isAutoFocusEnabled = true
        codescanner.isFlashEnabled = false

        codescanner.decodeCallback = DecodeCallback {
            activity?.runOnUiThread {
                Toast.makeText(requireContext(), "Scan Result: ${it.text}", Toast.LENGTH_SHORT)
                    .show()

                var splitedString = it.text.split("//://")
                _binding!!.totalTextView12.text = splitedString.toString()
                _binding!!.nameTextView13.text = splitedString[0]
                _binding!!.descriptionTextView14.text = splitedString[1]

                Picasso
                    .get()
                    .load(splitedString[2])
                    .into(_binding!!.imageView1);
                MainActivity.Users.activePokemon = Pokemon(splitedString[0], splitedString[1], splitedString[2])
                _binding!!.pokemonButton.isEnabled = true
            }
        }

        codescanner.errorCallback = ErrorCallback {
            activity?.runOnUiThread {
                Toast.makeText(
                    requireContext(),
                    "Camera initialization error: ${it.message} ",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        scannerView.setOnClickListener {
            codescanner.startPreview()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 123) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(requireContext(), "Camera permission granted", Toast.LENGTH_SHORT)
                    .show()
                startScanning()
            } else {
                Toast.makeText(requireContext(), "Camera permission denied", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        if (::codescanner.isInitialized) {
            codescanner?.startPreview()
        }
    }

    override fun onPause() {
        if (::codescanner.isInitialized) {
            codescanner?.releaseResources()
        }
        super.onPause()
    }



    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment QrCodeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            QrCodeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}