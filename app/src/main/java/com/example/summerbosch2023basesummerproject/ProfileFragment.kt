package com.example.summerbosch2023basesummerproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.summerbosch2023basesummerproject.databinding.FragmentLoginBinding
import com.example.summerbosch2023basesummerproject.databinding.FragmentProfileBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProfileFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfileFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var _binding: FragmentProfileBinding? = null

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
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return _binding!!.root;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        _binding!!.ProfileUsernameTextText.setText(MainActivity.Users.activeUser!!.username)

        _binding!!.ProfilePasswordTextText2.setText(MainActivity.Users.activeUser!!.password)

        _binding!!.ProfileEmailTextText3.setText(MainActivity.Users.activeUser!!.email)

        _binding!!.ProfileAgeTextText5.setText(MainActivity.Users.activeUser!!.age.toString())

        _binding!!.EditButton.setOnClickListener {

            MainActivity.Users.activeUser!!.username =
                _binding!!.ProfileUsernameTextText.text.toString()
            MainActivity.Users.activeUser!!.password =
                _binding!!.ProfilePasswordTextText2.text.toString()
            MainActivity.Users.activeUser!!.email = _binding!!.ProfileEmailTextText3.text.toString()
            MainActivity.Users.activeUser!!.age =
                _binding!!.ProfileAgeTextText5.text.toString().trim()
                    .split("\\s+".toRegex())[0].toInt()!!
            Toast.makeText(
                context,
                "Dados atualizados!",
                Toast.LENGTH_SHORT
            )
                .show()
            view.findNavController().navigate(R.id.action_profileFragment_to_navigation_home)
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ProfileFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProfileFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}