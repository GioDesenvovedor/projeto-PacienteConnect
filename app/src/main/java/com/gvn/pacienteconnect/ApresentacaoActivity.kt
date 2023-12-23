package com.gvn.pacienteconnect

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.gvn.pacienteconnect.databinding.ActivityApresentacaoBinding
import com.gvn.pacienteconnect.view.CadastroActivity


class ApresentacaoActivity : AppCompatActivity() {

    private  lateinit var binding: ActivityApresentacaoBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityApresentacaoBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //esconder actionBar
        supportActionBar?.hide()
        window.statusBarColor = Color.parseColor("#FE3942")

        proximatela()



    }

    private fun proximatela() {
        binding.button.setOnClickListener {
            startActivity(Intent(this, CadastroActivity::class.java))
            finish()
        }
    }
}