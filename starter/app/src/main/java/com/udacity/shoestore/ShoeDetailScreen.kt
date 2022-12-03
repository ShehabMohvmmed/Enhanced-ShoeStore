package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailScreenBinding
import com.udacity.shoestore.models.Shoe

class ShoeDetailScreen : Fragment() {
    lateinit var binding: FragmentShoeDetailScreenBinding
    //lateinit var mainActivity: MainActivity

    private val sharedViewModel: SharedViewModel by activityViewModels()
    private val shoe = Shoe()


    override fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_shoe_detail_screen,container,false)
        binding.shoeModel = shoe


            binding.cancelBtn.setOnClickListener {
                findNavController().navigateUp()
//            binding.textShoeName.text = num.toString()
            }

            binding.saveBtn.setOnClickListener {
              //  if (binding.editTextShoeName.text.isEmpty()) {
                    //Toast.makeText(requireContext(), "fill the field", Toast.LENGTH_SHORT).show()
              //  }else{

                val shoeDrawable = binding.shoeDetailImage.drawable
                shoe.image = shoeDrawable
//                if ( binding.editTextShoeSize.text == null) {
//                   shoe.size = 0.0
//                }


                sharedViewModel.addShoe(shoe)
//            val action = ShoeDetailScreenDirections.actionShoeDetailScreenToShoeList(shoe)
//            Navigation.findNavController(requireView()).navigate(action)
                    findNavController().navigateUp()
                    //Toast.makeText(requireContext(), "Shoe Created Successfully", Toast.LENGTH_SHORT).show()
              //  }
            }

        binding.uploadBtn.setOnClickListener {
           //mainActivity.pickImage()
            (activity as MainActivity).pickImage()
        }



        return binding.root
    }

    @BindingAdapter("imageResource")
    fun setImageResource(imageView: ImageView, resource: Int ) {
        imageView.setImageResource(resource)
    }

    @BindingAdapter("setImageViewResource")
    fun setImageViewResource(imageView: ImageView, resource: Int) {
        imageView.setImageResource(resource)
    }
}