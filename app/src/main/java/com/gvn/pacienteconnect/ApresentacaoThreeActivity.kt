package com.gvn.pacienteconnect

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gvn.pacienteconnect.databinding.ActivityApresentacaoThreeBinding
import com.gvn.pacienteconnect.view.CadastroActivity

class ApresentacaoThreeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityApresentacaoThreeBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityApresentacaoThreeBinding.inflate(layoutInflater)

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
            startActivity(Intent(this, CadastroActivity::class.java))
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