package com.udacity.shoestore

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.content.PackageManagerCompat
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe


class SharedViewModel: ViewModel() {

    var shoeList: MutableLiveData<ArrayList<Shoe>> = MutableLiveData(ArrayList<Shoe>())
    fun addShoe(shoe:Shoe) {
        shoeList.value?.add(shoe)
    }





}