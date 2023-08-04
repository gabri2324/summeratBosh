package com.example.summerbosch2023basesummerproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.summerbosch2023basesummerproject.databinding.FragmentHomeBinding
import com.example.summerbosch2023basesummerproject.databinding.FragmentLoginBinding
import com.example.summerbosch2023basesummerproject.databinding.FragmentTemperatureConvertBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TemperatureConvertFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TemperatureConvertFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var _binding: FragmentTemperatureConvertBinding? = null

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
        _binding = FragmentTemperatureConvertBinding.inflate(inflater, container, false)

        return _binding!!.root;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        _binding!!.conversionButton1.setOnClickListener {
            if (_binding!!.temperatureTextText.text.toString() != "") {
                var temperature: Double
                var result: Double

                temperature = (_binding!!.temperatureTextText.text.toString()).trim()
                    .split("\\s+".toRegex())[0].toDoubleOrNull()!!

                var finalTemperature = 9.0 / 5.0 * (temperature) + 32
                result = finalTemperature
                _binding!!.resultTextView2.text = result.toString();
            } else {
                Toast.makeText(context, "Por favor introduza algum valor!", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        _binding!!.conversionButton2.setOnClickListener {
            if (_binding!!.temperatureTextText.text.toString() != "") {
                var temperature: Double
                var result: Double

                temperature = (_binding!!.temperatureTextText.text.toString()).trim()
                    .split("\\s+".toRegex())[0].toDoubleOrNull()!!

                var finalTemperature = (temperature) - 273.15
                result = finalTemperature
                _binding!!.resultTextView2.text = result.toString()

            } else {
                Toast.makeText(context, "Por favor introduza algum valor!", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        _binding!!.conversionButton3.setOnClickListener {
            if (_binding!!.temperatureTextText.text.toString() != "") {
                var temperature: Double
                var result: Double

                temperature = (_binding!!.temperatureTextText.text.toString()).trim()
                    .split("\\s+".toRegex())[0].toDoubleOrNull()!!

                var finalTemperature = 5.0 / 9.0 * (temperature - 32) + 273.15
                result = finalTemperature
                _binding!!.resultTextView2.text = result.toString()

            } else {
                Toast.makeText(context, "Por favor introduza algum valor!", Toast.LENGTH_SHORT)
                    .show()
            }

        }
    }

}