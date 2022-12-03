package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.udacity.shoestore.databinding.FragmentInstructionsScreenBinding
import com.udacity.shoestore.databinding.FragmentLoginScreenBinding

class InstructionsScreen : Fragment() {
    lateinit var binding: FragmentInstructionsScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(false)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_instructions_screen,container,false)
        binding.instructionsScreenBtn.setOnClickListener {
            val action = InstructionsScreenDirections.actionInstructionsScreenToShoeList()
            Navigation.findNavController(requireView()).navigate(action)
        }

        return binding.root
    }
}