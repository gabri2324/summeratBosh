package com.example.summerbosch2023basesummerproject

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.summerbosch2023basesummerproject.databinding.FragmentLoginBinding
import com.example.summerbosch2023basesummerproject.databinding.FragmentMathBinding

class LoginFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var _binding: FragmentLoginBinding? = null
    private var ut: User = User()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return _binding!!.root;
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        onResume()
        if (ut.username != ""){
            MainActivity.Users.userobjects.add(ut)
            MainActivity.Users.activeUser = ut
            view.findNavController()
                .navigate(R.id.action_loginFragment_to_navigation_home3);
            return
        }

        _binding!!.loginbutton.setOnClickListener {

            val username: String = (_binding!!.usernameTextText.text.toString())
            val password: String = (_binding!!.editTextTextPassword.text.toString())

            var validador = false


            for (i in 0 until  MainActivity.Users.userobjects.size) {

                if (username == MainActivity.Users.userobjects[i].username && password == MainActivity.Users.userobjects[i].password) {
                    validador = true
                    MainActivity.Users.activeUser = MainActivity.Users.userobjects[i]

                }

            }
                // } else {
                //  Toast.makeText(
                //    context,
                //  "Username ou password estão incorretos!",
                //Toast.LENGTH_SHORT
                //  )
                //.show()
                if (validador) {
                    save()
                    view.findNavController()
                        .navigate(R.id.action_loginFragment_to_navigation_home3);
                } else {
                    Toast.makeText(
                        context,
                        "Username ou password estão incorretos!",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }

            }
        _binding!!.registobutton.setOnClickListener {
            view.findNavController().navigate(R.id.action_loginFragment_to_registoFragment)
        }
    }
    private fun save() {

        // Creating a shared pref object with a file name "MySharedPref" in private mode
        val sharedPreferences = requireActivity().getSharedPreferences("MySharedPref",
            Context.MODE_PRIVATE
        )
        val myEdit = sharedPreferences.edit()

        // write all the data entered by the user in SharedPreference and apply
        myEdit.putString("username", MainActivity.Users.activeUser!!.username)
        myEdit.putString("password", MainActivity.Users.activeUser!!.password)
        myEdit.putString("email", MainActivity.Users.activeUser!!.email)
        myEdit.putInt("age", MainActivity.Users.activeUser!!.age)
        myEdit.apply()
    }

    override fun onResume() {
        super.onResume()
        val sharedPreferences = requireActivity().getSharedPreferences("MySharedPref",
            Context.MODE_PRIVATE)
        val username = sharedPreferences.getString("username", null)
        val password = sharedPreferences.getString("password", null)
        val email = sharedPreferences.getString("email", null)
        val age = sharedPreferences.getInt("age", -1)

        if(username != null && password != null && email != null && age != -1){
            ut.setUser(username, password, email, age)
        }
    }

}