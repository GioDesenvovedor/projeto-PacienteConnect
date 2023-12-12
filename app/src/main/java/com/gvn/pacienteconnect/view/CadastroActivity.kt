package com.gvn.pacienteconnect.view

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.gvn.pacienteconnect.database.CadPaciente
import com.gvn.pacienteconnect.databinding.ActivityCadastroBinding
import com.gvn.pacienteconnect.viewModel.CadPacienteViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CadastroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCadastroBinding
    private val viewModel: CadPacienteViewModel by viewModels()
    private var guestId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityCadastroBinding.inflate(layoutInflater)

        //viewModel = ViewModelProvider(this).get(CadPacienteViewModel::class.java)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        //esconder actionBar
        supportActionBar?.hide()
        window.statusBarColor = Color.parseColor("#FE3942")

        btnSave()

    }

    private fun btnSave() {
        binding.btnSalvar.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                insertCad()
            }

        }
    }

    private suspend fun insertCad() {

        val nome = binding.editNome.text.toString()
        var sobrenome = binding.editSobreNome.text.toString()
        var problemaSaude = binding.editProblema.text.toString()

        if (nome.isNotEmpty() && problemaSaude.isNotEmpty()) {

            withContext(Dispatchers.IO) {
                val model = CadPaciente().apply {
                    this.id = guestId
                    this.nome = nome
                    this.sobrenome = sobrenome
                    this.problema = problemaSaude
                }
                viewModel.insert(model)
            }
            withContext(Dispatchers.Main) {
                startActivity(Intent(applicationContext, ListaPacientes::class.java))
                finish()
            }


        }else{
            withContext(Dispatchers.Main){
                Toast.makeText(applicationContext, "Os campos não pode ser vazios ", Toast.LENGTH_LONG).show()
            }

        }

    }
}