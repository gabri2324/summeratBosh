package com.example.summerbosch2023basesummerproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.summerbosch2023basesummerproject.SaveData.saveUsers
import com.example.summerbosch2023basesummerproject.databinding.FragmentRegistoBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RegistoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegistoFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var _binding: FragmentRegistoBinding? = null

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
        _binding = FragmentRegistoBinding.inflate(inflater, container, false)
        return _binding!!.root;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding!!.registo2button.setOnClickListener {
            var username = _binding!!.username2TextText.text.toString()
            var password = _binding!!.password2TextText3.text.toString()
            var email = _binding!!.emailTextText2.text.toString()
            var age = _binding!!.ageTextText.text.toString().trim()
                .split("\\s+".toRegex())[0].toInt()!!
            if (checkUsername(username) && checkPassword(password)) {

                MainActivity.Users.userobjects.add(User(username, password, email, age))
                view.findNavController().navigate(R.id.action_registoFragment_to_loginFragment)

                //saveUsers(requireContext(),  MainActivity.Users.userobjects)

            } else {
                Toast.makeText(
                    context,
                    "As suas credenciais não cumprem com os requesitos!",
                    Toast.LENGTH_SHORT
                )
                    .show()
            }
        }
    }

    private fun checkUsername(username: String): Boolean {
        return username.length >= 5
    }

    private fun checkPassword(password: String): Boolean {
        val regexStr = "^[0-9]*$"

        return password.contains("[0-9]".toRegex()) && password.length >= 7

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RegistoFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RegistoFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}