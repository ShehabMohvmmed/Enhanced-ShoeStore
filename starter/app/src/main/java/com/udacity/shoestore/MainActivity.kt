package com.udacity.shoestore

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.udacity.shoestore.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    //lateinit var bindingShoeImage : FragmentShoeDetailScreenBinding
    lateinit var navController: NavController

    var pickedImage: Uri? = null
    var pickedBitMap: Bitmap? = null

    companion object {
        val IMAGE_REQUEST_CODE = 1_000;
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        Timber.plant(Timber.DebugTree())

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.findNavController()
        setSupportActionBar(binding.toolbar)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.loginScreen,
                R.id.welcome_screen,
                R.id.instructions_screen,
                R.id.shoeList
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

//    fun pickImageFromGallery() {
//        val intent = Intent(Intent.ACTION_PICK)
//        intent.type = "image/*"
//        startActivityForResult(intent, IMAGE_REQUEST_CODE)
//    }
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (requestCode == IMAGE_REQUEST_CODE && resultCode == RESULT_OK) {
//            bindingShoeImage.shoeImage.setImageURI(data?.data)
//        }
//    }

    fun pickImage() {
        if (ContextCompat.checkSelfPermission(this,android.Manifest.permission.READ_EXTERNAL_STORAGE)
            != PackageManager.PERMISSION_GRANTED ) {
            ActivityCompat.requestPermissions(this,
                arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE),1)
        }else{
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent,IMAGE_REQUEST_CODE)
        }
    }

//    override fun onRequestPermissionsResult(
//        requestCode: Int,
//        permissions: Array<out String>,
//        grantResults: IntArray
//    ) {
//        if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//            val galleryInText = Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
//            startActivityForResult(galleryInText,2)
//        }
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == IMAGE_REQUEST_CODE && resultCode == Activity.RESULT_OK && data!=null){
//            pickedImage = data.data
//            if(Build.VERSION.SDK_INT >= 28) {
//                val source = ImageDecoder.createSource(this.contentResolver, pickedImage!!)
//                pickedBitMap = ImageDecoder.decodeBitmap(source)
//                bindingShoeImage.shoeImage.setImageBitmap(pickedBitMap)
//            } else {
//                pickedBitMap = MediaStore.Images.Media.getBitmap(this.contentResolver,pickedImage)
//                bindingShoeImage.shoeImage.setImageBitmap(pickedBitMap)
//            }
            //bindingShoeImage.shoeImage.setImageURI(data.data)
            findViewById<ImageView>(R.id.shoe_detail_image).setImageURI(data.data)

        }
        super.onActivityResult(requestCode, resultCode, data)
    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        if (requestCode == 2 && resultCode == Activity.RESULT_OK && data!=null){
////            pickedImage = data.data
////            if(Build.VERSION.SDK_INT >= 28) {
////                val source = ImageDecoder.createSource(this.contentResolver, pickedImage!!)
////                pickedBitMap = ImageDecoder.decodeBitmap(source)
////                bindingShoeImage.shoeImage.setImageBitmap(pickedBitMap)
////            } else {
////                pickedBitMap = MediaStore.Images.Media.getBitmap(this.contentResolver,pickedImage)
////                bindingShoeImage.shoeImage.setImageBitmap(pickedBitMap)
////            }
//            bindingShoeImage.shoeImage.setImageURI(data.data)
//        }
//        super.onActivityResult(requestCode, resultCode, data)
//    }


}