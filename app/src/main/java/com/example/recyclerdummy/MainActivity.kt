package com.example.recyclerdummy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerdummy.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.fragment_home.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        @Suppress("UNUSED_VARIABLE")
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        val navController = this.findNavController(R.id.NavFragment)
        NavigationUI.setupActionBarWithNavController(this , navController)

//        val details = listOf(
//            details("led zeppelin", "", "jimmy page, john bonham, robert plant, john paul jones"),
//            details("The beatles", "", "jimmy page, john bonham, robert plant, john paul jones"),
//            details("Pink Floyd", "", "jimmy page, john bonham, robert plant, john paul jones"),
//            details("Guns N' Roses", "", "jimmy page, john bonham, robert plant, john paul jones"),
//            details("Radiohead", "", "jimmy page, john bonham, robert plant, john paul jones"),
//            details("Gary Moore", "", "jimmy page, john bonham, robert plant, john paul jones")
//
//        )
//        recyclerlist.layoutManager = LinearLayoutManager(this)
//        recyclerlist.adapter = detailsAdapter(details)

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.NavFragment)
        return navController.navigateUp()
    }
}