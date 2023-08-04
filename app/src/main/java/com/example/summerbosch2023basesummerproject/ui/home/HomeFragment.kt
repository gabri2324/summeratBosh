package com.example.summerbosch2023basesummerproject.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.summerbosch2023basesummerproject.MainActivity
import com.example.summerbosch2023basesummerproject.R
import com.example.summerbosch2023basesummerproject.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this)[HomeViewModel::class.java]

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root;

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        _binding!!.goToMathFragment.setOnClickListener {

        view.findNavController().navigate(R.id.action_navigation_home_to_mathFragment);
        }
        _binding!!.swichToTestFragment.setOnClickListener {

            view.findNavController().navigate(R.id.action_navigation_home_to_testFragment);
        }
        _binding!!.swichToGalleryFragment.setOnClickListener {

            view.findNavController().navigate(R.id.action_navigation_home_to_galleryFragment);
        }
        _binding!!.temperatureButton.setOnClickListener {

            view.findNavController().navigate(R.id.action_navigation_home_to_temperatureConvertFragment)
        }
        _binding!!.callbutton.setOnClickListener {

            view.findNavController().navigate(R.id.action_navigation_home_to_presenceFragment)
        }
        _binding!!.textactive.setText(MainActivity.Users.activeUser!!.username)

        _binding!!.profileButton.setOnClickListener {

            view.findNavController().navigate(R.id.action_navigation_home_to_profileFragment)
        }
        _binding!!.qrcodeButton.setOnClickListener {

            view.findNavController().navigate(R.id.action_navigation_home_to_qrCodeFragment)
        }
        _binding!!.colectionButton.setOnClickListener {

            view.findNavController().navigate(R.id.action_navigation_home_to_pokemonColectionFragment)
        }
        _binding!!.logoutButton.setOnClickListener {
            // Creating a shared pref object with a file name "MySharedPref" in private mode
            val sharedPreferences = requireActivity().getSharedPreferences("MySharedPref",
                Context.MODE_PRIVATE
            )
            val myEdit = sharedPreferences.edit()

            // write all the data entered by the user in SharedPreference and apply
            myEdit.putString("username", "")
            myEdit.putString("password", "")
            myEdit.putString("email", "")
            myEdit.putInt("age", -1)
            myEdit.apply()

            view.findNavController().navigate(R.id.action_navigation_home_to_loginFragment)
        }
    }
}