package com.example.camara

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.Manifest
import android.content.ContentValues
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.io.File
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private val REQUEST_CAMERA_PERMISSION = 200
    private val REQUEST_IMAGE_CAPTURE = 1
    private lateinit var imageView: ImageView
    private var currentImagePath: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val takePhotoButton: Button = findViewById(R.id.btn_take_photo)
        imageView = findViewById(R.id.image_view)

        takePhotoButton.setOnClickListener {
            if (ContextCompat.checkSelfPermission(
                    this@MainActivity,
                    Manifest.permission.CAMERA
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                openCamera()
            } else {
                ActivityCompat.requestPermissions(
                    this@MainActivity,
                    arrayOf(Manifest.permission.CAMERA),
                    REQUEST_CAMERA_PERMISSION
                )
            }
        }
    }

    private fun openCamera() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureIntent.resolveActivity(packageManager)?.also {
                val imageFile: File? = createImageFile()
                imageFile?.also {
                    val imageUri: Uri = Uri.fromFile(it)
                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri)
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
                }
            }
        }
    }

    private fun createImageFile(): File? {
        val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
        val imageFileName = "IMG_$timeStamp.jpg"
        val storageDir: File? = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile(imageFileName, null, storageDir).apply {
            currentImagePath = absolutePath
        }
    }

    private fun saveImageToGallery() {
        val imageFile = File(currentImagePath)
        val bitmap: Bitmap = MediaStore.Images.Media.getBitmap(contentResolver, Uri.fromFile(imageFile))

        val values = ContentValues().apply {
            put(MediaStore.Images.Media.TITLE, "My Image")
            put(MediaStore.Images.Media.DESCRIPTION, "Image captured by my app")
            put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg")
        }
    }  }