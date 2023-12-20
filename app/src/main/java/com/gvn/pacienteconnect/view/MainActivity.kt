package com.gvn.pacienteconnect.view

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.gvn.pacienteconnect.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()
        window.statusBarColor = Color.parseColor("#FFFFFFFF")

        // Splash
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, CadastroActivity::class.java)
            startActivity(intent)
            finish()
        },3000)// tempo do splash
    }
}