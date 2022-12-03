package com.udacity.shoestore.models

import android.graphics.drawable.Drawable
import android.os.Parcelable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import kotlinx.parcelize.Parcelize



data class Shoe(
    var name: String = "",
    var size: Double? = null,
    var company: String = "",
    var description: String = "",
    var image: Drawable? = null
)



//@Parcelize
//data class Shoe(
//    var name: String = "",
//    var size: Double? = null,
//    var company: String = "",
//    var description: String = "",
//    val images: List<String> = mutableListOf()
//) : Parcelable

//val shoe = Shoe(
//     name = "",
//    size= null,
//     company= "",
//     description = "",
//     images = null
//)