package com.example.mp3kotlin

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private companion object {
        private const val PERMISSION_REQUEST_CODE = 1
    }

    private var mediaPlayer: MediaPlayer? = null

    private lateinit var btnPlay: Button
    private lateinit var btnPause: Button
    private lateinit var btnStop: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnPlay = findViewById(R.id.btnPlay)
        btnPause = findViewById(R.id.btnPause)
        btnStop = findViewById(R.id.btnStop)

        btnPlay.setOnClickListener {
            if (checkPermission()) {
                playAudio()
            } else {
                requestPermission()
            }
        }

        btnPause.setOnClickListener {
            pauseAudio()
        }

        btnStop.setOnClickListener {
            stopAudio()
        }
    }

    private fun checkPermission(): Boolean {
        val result = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
        return result == PackageManager.PERMISSION_GRANTED
    }

    private fun requestPermission() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
            PERMISSION_REQUEST_CODE
        )
    }

    @SuppressLint("MissingSuperCall")
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                playAudio()
            } else {
                Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun playAudio() {
        mediaPlayer = MediaPlayer.create(this, R.raw.¡)
        mediaPlayer?.start()
        Toast.makeText(this, "Playing audio", Toast.LENGTH_SHORT).show()
    }

    private fun pauseAudio() {
        mediaPlayer?.let {
            if (it.isPlaying) {
                it.pause()
                Toast.makeText(this, "Audio paused", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun stopAudio() {
        mediaPlayer?.let {
            if (it.isPlaying) {
                it.stop()
                it.release()
                mediaPlayer = null
                Toast.makeText(this, "Audio stopped", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
