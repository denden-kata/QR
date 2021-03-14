package com.example.qr

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkPermission()
    }

    /**
     * カメラのパーミッションが取れているか確認.
     */
    private fun checkPermission() {
        if (checkSelfPermission(android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            Log.d("checkPermission", "SUCCESS")
        } else {
            Log.d("checkPermission", "FAILED")
        }
    }

}