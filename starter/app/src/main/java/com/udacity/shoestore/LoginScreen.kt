package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.ActivityMainBinding
import com.udacity.shoestore.databinding.FragmentLoginScreenBinding

class LoginScreen : Fragment() {
    lateinit var binding: FragmentLoginScreenBinding

    override fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login_screen, container, false)

        binding.newLoginBtn.setOnClickListener {
            val action = LoginScreenDirections.actionLoginScreenToWelcomeScreen()
            Navigation.findNavController(requireView()).navigate(action)
        }

        binding.existLoginBtn.setOnClickListener {
            val action = LoginScreenDirections.actionLoginScreenToWelcomeScreen()
            Navigation.findNavController(requireView()).navigate(action)
        }

        return binding.root
    }
}