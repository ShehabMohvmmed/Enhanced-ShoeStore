package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBindings
import com.udacity.shoestore.databinding.FragmentShoeListScreenBinding
import com.udacity.shoestore.databinding.ListItemBinding

import com.udacity.shoestore.models.Shoe

class ShoeListScreen : Fragment() {
    private lateinit var binding: FragmentShoeListScreenBinding
//    private lateinit var bindingItem: ListItemBinding
    private val sharedViewModel: SharedViewModel by activityViewModels()
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private lateinit var adapter: RecyclerView.Adapter<MyAdapter.MyViewHolder>
    //private lateinit var shoeList: ArrayList<Shoe>
//    lateinit var shoeImage: Array<Int>
//    lateinit var shoeName: Array<String>
//    lateinit var shoeCompany: Array<String>
//    lateinit var shoeDescription: Array<String>
//    lateinit var shoeSize: Array<String>


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_shoe_list_screen,container,false)



        binding.floatingActionButton.setOnClickListener {
            val action = ShoeListScreenDirections.actionShoeListToShoeDetailScreen()
            Navigation.findNavController(requireView()).navigate(action)
        }



//        myRecyclerView = binding.recyclerView
//        myRecyclerView.layoutManager = LinearLayoutManager(requireContext())
//        myRecyclerView.setHasFixedSize(true)


        layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.layoutManager = layoutManager
        adapter = MyAdapter(sharedViewModel.shoeList.value!!)
        binding.recyclerView.adapter = adapter


//            sharedViewModel.shoeList.observe(viewLifecycleOwner) { shoesList ->
//                shoesList.forEach { shoe ->
//                    bindingItem.tvShoeName.text = shoe.name
//                    bindingItem.tvShoeCompany.text = shoe.company
//                    bindingItem.tvShoeSize.text = shoe.size.toString()
//                    bindingItem.tvShoeDescription.text = shoe.description
//
////                val shoeLayout = ShoeItemLinearlayoutBinding.inflate(inflater)
////                shoeLayout.shoeDetail = shoe
////                binding.shoeListScreen.addView(shoeLayout.root)
//
//
//                    //myRecyclerView.adapter = MyAdapter(sharedViewModel.shoeList.value!!)
//                }
//            }



            return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_main,menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.loginScreen) {
            val action = ShoeListScreenDirections.actionShoeListToLoginScreen()
            Navigation.findNavController(requireView()).navigate(action)
        }
        return super.onOptionsItemSelected(item)
    }



}
