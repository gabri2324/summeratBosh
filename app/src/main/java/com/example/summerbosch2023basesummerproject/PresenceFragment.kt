package com.example.summerbosch2023basesummerproject

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.fragment.app.Fragment
import com.example.summerbosch2023basesummerproject.databinding.FragmentPresenceBinding
import okhttp3.Call
import okhttp3.Callback
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import okio.IOException


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PresenceFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PresenceFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var _binding: FragmentPresenceBinding? = null
    private val client = OkHttpClient()

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
        _binding = FragmentPresenceBinding.inflate(inflater, container, false)
        return _binding!!.root;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        _binding!!.makecallbutton.setOnClickListener {
            run(
                "https://praesensasummerprojectovar.azurewebsites.net/api/praesensa/prascl-0ea50e-ctrl.local/call",
                _binding!!.prioridadeseekBar3.progress,
                _binding!!.zonaspinner.selectedItem.toString(),
                _binding!!.mensagemspinner2.selectedItem.toString()
            )


        }
        _binding!!.prioridadeseekBar3.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
               _binding!!.textView3.setText(p1.toString())
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                // Do nothing
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                // Do nothing
            }

        })
        val list: MutableList<String> = ArrayList()
        list.add("Zone 1")
        list.add("Zone 2")
        list.add("Zone 3")
        list.add("Zone 4")
        val adp1: ArrayAdapter<String> = ArrayAdapter<String>(
            requireContext(),
            R.layout.simple_list_item_1, list
        )
        adp1.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
        _binding!!.zonaspinner.adapter = adp1


        val list2: MutableList<String> = ArrayList()
        list2.add("evacu")
        list2.add("airport")
        list2.add("acdc")
        list2.add("thx")
        list2.add("welcome")
        list2.add("vader")
        list2.add("route_changed")
        list2.add("start_evacuation")
        val adp2: ArrayAdapter<String> = ArrayAdapter<String>(
            requireContext(),
            R.layout.simple_list_item_1, list2
        )
        adp2.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
        _binding!!.mensagemspinner2.adapter = adp2


    }


    fun run(url: String, prioridade: Int, zona: String, mensagem: String) {
        // val json = "{\"id\":1,\"name\":\"John\"}"
        val json =
            "{\"Priority\":" + prioridade.toString() + ",\"Zones\": [\"" + zona + "\"],\"Message\":\"" + mensagem + "\"}"

        val body = json
            .toRequestBody("application/json".toMediaTypeOrNull())

        val request = Request.Builder()
            .url(url)
            .addHeader("ApiKey", "AIzaSyCoUDdflZ7cTQJXtxr3LntWlfFtvtAS0lk")
            .post(body)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {}
            override fun onResponse(call: Call, response: Response) =
                println(response.body?.string())
        })
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PresenceFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PresenceFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}