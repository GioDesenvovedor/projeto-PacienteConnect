package com.gvn.pacienteconnect

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gvn.pacienteconnect.databinding.ActivityApresentacaoTwoBinding
import com.gvn.pacienteconnect.view.CadastroActivity

class ApresentacaoTwoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityApresentacaoTwoBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityApresentacaoTwoBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //esconder actionBar
        supportActionBar?.hide()
        window.statusBarColor = Color.parseColor("#FE3942")

        proximatela()
        pulartela()

    }

    private fun proximatela() {
        binding.button.setOnClickListener {
            startActivity(Intent(this, ApresentacaoThreeActivity::class.java))
            finish()
        }
    }

    private fun pulartela() {
        binding.btnPular.setOnClickListener {
            startActivity(Intent(this, CadastroActivity::class.java))
            finish()
        }
    }
}