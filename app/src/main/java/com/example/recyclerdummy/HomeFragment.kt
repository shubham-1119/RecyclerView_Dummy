package com.example.recyclerdummy


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerdummy.databinding.FragmentHomeBinding
import com.facebook.drawee.backends.pipeline.Fresco
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.fragment_home.*
import java.io.IOException


class HomeFragment : Fragment() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentHomeBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_home,
            container,
            false
        )
//        binding.button.setOnClickListener{ view: View->
//            Navigation.findNavController(view).navigate(HomeFragmentDirections.actionHomeFragmentToDetailsFragment())
//        }

        Fresco.initialize(context);

        setHasOptionsMenu(true)
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.title_home)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val jsonFileString = getJsonDataFromAsset(requireContext(), "details.json")
        val trimmed: String = jsonFileString!!.trim()
        val gson = Gson()
        val listDetails = object : TypeToken<List<details>>() {}.type

        var details: List<details> = gson.fromJson(trimmed, listDetails)

        recyclerlist.layoutManager = LinearLayoutManager(this.context)
        recyclerlist.adapter = detailsAdapter(details)

    }

    fun getJsonDataFromAsset(context: Context, fileName: String): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }


}