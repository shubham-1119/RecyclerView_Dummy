package com.example.recyclerdummy

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ShareCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.recyclerdummy.databinding.FragmentDetailsBinding
import com.facebook.drawee.view.SimpleDraweeView
import kotlinx.android.synthetic.main.fragment_details.*


class DetailsFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentDetailsBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_details,
            container,
            false
        )
        setHasOptionsMenu(true)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var args = DetailsFragmentArgs.fromBundle(arguments!!)
        val imageUri: Uri = Uri.parse(args.url)
        bandImage.setImageURI(imageUri)
        bandDesc.setText(args.desc)
        //bandDesc.append(args.desc)
        bandDesc.movementMethod=ScrollingMovementMethod()



        (activity as AppCompatActivity).supportActionBar?.title = args.title

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.share_details, menu)
    }
    private fun getShareIntent(): Intent {

        var args = DetailsFragmentArgs.fromBundle(arguments!!)
        return ShareCompat.IntentBuilder.from(activity!!)
            .setText(args.title)
            .setType("text/plain").intent
    }
    private fun shareSuccess(){
        startActivity(getShareIntent())
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item!!.itemId)
        {
            R.id.share -> shareSuccess()
        }
        return super.onOptionsItemSelected(item)
    }


}