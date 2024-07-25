package com.itarm.openinappdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.itarm.openinappdemo.app.AppController
import com.itarm.openinappdemo.ui.home.HomeActivity
import java.lang.ref.WeakReference

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        AppController.init(WeakReference(this), "", "")
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }
}