package com.example.summerbosch2023basesummerproject.ui.math

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.summerbosch2023basesummerproject.R
import com.example.summerbosch2023basesummerproject.databinding.FragmentHomeBinding
import com.example.summerbosch2023basesummerproject.databinding.FragmentMathBinding


/**
 * A simple [Fragment] subclass.
 * create an instance of this fragment.
 */
class MathFragment : Fragment() {


    private var _binding: FragmentMathBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentMathBinding.inflate(inflater, container, false)
        return _binding!!.root;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        _binding!!.multiplicateButton.setOnClickListener {

            if (_binding!!.number1Input.text.toString() != "" && _binding!!.number2Input.text.toString() != "") {
                var number1: Double;
                var number2: Double;
                var result: Double;

                number1 = (_binding!!.number1Input.text.toString())!!.trim()
                    .split("\\s+".toRegex())[0].toDoubleOrNull()!!
                number2 = (_binding!!.number2Input.text.toString())!!.trim()
                    .split("\\s+".toRegex())[0].toDoubleOrNull()!!

                result = number1 * number2;

                _binding!!.resultTextView.text = result.toString();
            } else {
                Toast.makeText(context, "Por favor introduza algum valor!", Toast.LENGTH_SHORT)
                    .show()

            }

        }
        _binding!!.plusbutton.setOnClickListener {

            if (_binding!!.number1Input.text.toString() != "" && _binding!!.number2Input.text.toString() != "") {
                var number1: Double;
                var number2: Double;
                var result: Double;

                number1 = (_binding!!.number1Input.text.toString())!!.trim()
                    .split("\\s+".toRegex())[0].toDoubleOrNull()!!
                number2 = (_binding!!.number2Input.text.toString())!!.trim()
                    .split("\\s+".toRegex())[0].toDoubleOrNull()!!

                result = number1 + number2;

                _binding!!.resultTextView.text = result.toString();
            } else {
                Toast.makeText(context, "Por favor introduza algum valor!", Toast.LENGTH_SHORT)
                    .show()
            }

        }
        _binding!!.dividebutton.setOnClickListener {

            if (_binding!!.number1Input.text.toString() != "" && _binding!!.number2Input.text.toString() != "") {
                var number1: Double;
                var number2: Double;
                var result: Double;

                number1 = (_binding!!.number1Input.text.toString())!!.trim()
                    .split("\\s+".toRegex())[0].toDoubleOrNull()!!
                number2 = (_binding!!.number2Input.text.toString())!!.trim()
                    .split("\\s+".toRegex())[0].toDoubleOrNull()!!


                result = number1 / number2;

                _binding!!.resultTextView.text = result.toString();

            } else {
                Toast.makeText(context, "Por favor introduza algum valor!", Toast.LENGTH_SHORT)
                    .show()
            }

        }
        _binding!!.subtractButton.setOnClickListener {

            if (_binding!!.number1Input.text.toString() != "" && _binding!!.number2Input.text.toString() != "") {
                var number1: Double;
                var number2: Double;
                var result: Double;

                number1 = (_binding!!.number1Input.text.toString())!!.trim()
                    .split("\\s+".toRegex())[0].toDoubleOrNull()!!
                number2 = (_binding!!.number2Input.text.toString())!!.trim()
                    .split("\\s+".toRegex())[0].toDoubleOrNull()!!

                result = number1 - number2;

                _binding!!.resultTextView.text = result.toString();
            } else {
                Toast.makeText(context, "Por favor introduza algum valor!", Toast.LENGTH_SHORT)
                    .show()
            }

        }
        }
    }