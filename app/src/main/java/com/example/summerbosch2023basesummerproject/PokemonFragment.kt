package com.example.summerbosch2023basesummerproject

import android.content.Context.MODE_APPEND
import android.content.Context.MODE_PRIVATE
import android.os.Bundle
import android.view.Display.Mode
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.summerbosch2023basesummerproject.databinding.FragmentPokemonBinding
import com.example.summerbosch2023basesummerproject.databinding.FragmentQrCodeBinding
import com.squareup.picasso.Picasso

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PokemonFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PokemonFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var _binding: FragmentPokemonBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    private fun save() {
        super.onPause()
        // Creating a shared pref object with a file name "MySharedPref" in private mode
        val sharedPreferences = requireActivity().getSharedPreferences("Pokemon", MODE_APPEND)
        val myEdit = sharedPreferences.edit()

        // write all the data entered by the user in SharedPreference and apply
        myEdit.putString("name", MainActivity.Users.activePokemon!!.name)
        myEdit.putString("description", MainActivity.Users.activePokemon!!.description)
        myEdit.putString("image", MainActivity.Users.activePokemon!!.url)
        myEdit.apply()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentPokemonBinding.inflate(inflater, container, false)
        return _binding!!.root;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        _binding!!.pokemonNameTextView8.text = MainActivity.Users.activePokemon!!.name
        _binding!!.pokemonDescriptionTextView8.text = MainActivity.Users.activePokemon!!.description
        Picasso
            .get()
            .load(MainActivity.Users.activePokemon!!.url)
            .into(_binding!!.imageView2);

        _binding!!.addButton.setOnClickListener {
            save()
            view.findNavController().navigate(R.id.action_pokemonFragment_to_pokemonColectionFragment)
        }



    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PokemonFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PokemonFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}