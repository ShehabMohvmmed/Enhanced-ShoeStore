package com.udacity.shoestore

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.udacity.shoestore.models.Shoe

//lateinit var binding: ListItemBinding
//private val sharedViewModel: SharedViewModel by Delegates.notNull<SharedViewModel>()

class MyAdapter(private val shoeList: ArrayList<Shoe>): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    //Binds the given View to the position
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return MyViewHolder(itemView)
    }

    //Called by RecyclerView to display the data at the specified position.
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        //sharedViewModel.shoeList.observe(LifecycleOwner) { shoesList ->
           // sharedViewModel.shoeList.value!!.forEach { shoe ->

//                currentItem.image?.let {
//                    holder.shoeImage.setImageResource(it)
//                }
//        fun doubleToInt(value: Double):Int


//        val shoeSizeDouble = DoubleConverter.doubleToString(currentItem.size)
        val currentItem = shoeList[position]
        holder.shoeImage.setImageDrawable(currentItem.image)
        holder.shoeName.text = currentItem.name
        if (currentItem.size == null){
            holder.shoeSize.text = ""
        } else {
            holder.shoeSize.text = currentItem.size!!.toInt().toString()
        }
        holder.shoeCompany.text = currentItem.company
        holder.shoeDescription.text = currentItem.description


//        if(holder.shoeSize.text == null) {
//            holder.shoeSize.text = null ?: ""
//        } else {
//            holder.shoeSize.text = currentItem.size.toString()
//        }
        //holder.shoeSize.text = null ?: ""
//        if(holder.shoeSize.text != null) {
//            holder.shoeSize.text = currentItem.size.toString()
//        } else {
//            holder.shoeSize.text = ""
//        }





//                val shoeLayout = ShoeItemLinearlayoutBinding.inflate(inflater)
//                shoeLayout.shoeDetail = shoe
//                binding.shoeListScreen.addView(shoeLayout.root)


                //myRecyclerView.adapter = MyAdapter(sharedViewModel.shoeList.value!!)
          //  }
       // }


    }

    override fun getItemCount(): Int {
        return shoeList.size
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val shoeImage: ImageView = itemView.findViewById(R.id.shoe_recycler_image)
        val shoeName: TextView = itemView.findViewById(R.id.tv_shoe_name)
        val shoeSize: TextView = itemView.findViewById(R.id.tv_shoe_size)
        val shoeCompany: TextView = itemView.findViewById(R.id.tv_shoe_company)
        val shoeDescription: TextView = itemView.findViewById(R.id.tv_shoe_description)

    }

}