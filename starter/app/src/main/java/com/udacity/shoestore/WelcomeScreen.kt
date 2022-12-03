package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.udacity.shoestore.databinding.FragmentLoginScreenBinding
import com.udacity.shoestore.databinding.FragmentWelcomeScreenBinding

class WelcomeScreen : Fragment() {
    lateinit var binding: FragmentWelcomeScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(false)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_welcome_screen,container,false)

        binding.welcomeScreenBtn.setOnClickListener {
            val action = WelcomeScreenDirections.actionWelcomeScreenToInstructionsScreen2()
            Navigation.findNavController(requireView()).navigate(action)
        }
        return binding.root
    }

}