package com.example.qr

import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {

    companion object {
        const val REQUEST_CODE: Int = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkPermission()
    }

    /**
     * アプリに必要なパーミッションのリクエストを行う
     */
    private fun requestPermission() {
        if (Build.VERSION.SDK_INT >= 24) {
            val permission: Array<String> = (
                    arrayOf(android.Manifest.permission.CAMERA)
                    )
            ActivityCompat.requestPermissions(this, permission, REQUEST_CODE)
        }
    }

    /**
     * カメラのパーミッションが許可されているか確認.
     * 許可されていない場合はパーミッションのリクエストを行う
     */
    private fun checkPermission() {
        if (checkSelfPermission(android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            Log.d("checkPermission", "Permission completed")
        } else {
            requestPermission()
            Log.d("checkPermission", "Permission not completed")
        }
    }

}