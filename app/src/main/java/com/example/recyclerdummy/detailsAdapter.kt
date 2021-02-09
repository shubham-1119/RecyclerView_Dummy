package com.example.recyclerdummy

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_item.view.*

class detailsAdapter(val details: List<details>) : RecyclerView.Adapter<detailsAdapter.detailsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): detailsViewHolder {
//        return detailsViewHolder(
//            LayoutInflater.from(parent.context).inflate(R.layout.layout_item, parent, false)
//        )
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.layout_item, parent, false)
        return detailsViewHolder(view)
    }

    override fun getItemCount()= details.size


    override fun onBindViewHolder(holder: detailsViewHolder, position: Int) {
        val detail = details[position]
        holder.view.textViewTitle.text = detail.title
        holder.view.textViewDesc.text = detail.desc


        val imageUri: Uri = Uri.parse(detail.url)
        holder.view.imageView.setImageURI(imageUri)
        holder.view.card.setOnClickListener { v: View->
            //Navigation.findNavController(v).navigate(HomeFragmentDirections.actionHomeFragmentToDetailsFragment(detail.title,detail.url,detail.desc))
            v.findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDetailsFragment(detail.title,detail.url,detail.desc))

        }


    }

    class detailsViewHolder(val view: View) : RecyclerView.ViewHolder(view)
}