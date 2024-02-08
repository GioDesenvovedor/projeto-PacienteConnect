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

        binding.radFemi.isChecked

        //radChecSexo()
        btnSave()

    }


    /*  Ao selecionar o radio botton miligrama dispara o evento loadSpinner2
    private fun radChecSexo() {
        binding.radMasc.setOnCheckedChangeListener { compoundButton, masc ->
            if (masc) {
                CadPaciente().sexo = true
            }else{
               radFem()
            }
        }
    }

    private fun radFem(){
        binding.radFemi.setOnCheckedChangeListener { compoundButton, fem ->
            if (fem) {
                CadPaciente().sexo = false
            }
        }
    }*/

    private fun btnSave() {
        binding.btnSalvar.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                insertCad()
            }

        }
    }

    private suspend fun insertCad() {

        val nome = binding.editNome.text.toString().trim()
        val sobrenome = binding.editSobreNome.text.toString().trim()
        val problemaSaude = binding.editProblema.text.toString().trim()
        val idade = binding.editIdade.text.toString().trim()
        //val feminino = binding.radFemi.text.toString()


        if (nome.isNotEmpty() && problemaSaude.isNotEmpty()) {

            withContext(Dispatchers.IO) {
                val model = CadPaciente().apply {
                    this.id = guestId
                    this.nome = nome
                    this.sobrenome = sobrenome
                    this.problema = problemaSaude
                    this.idade = idade
                   // this.feminino = feminino
                   // this.masculino = masculino
                }
                viewModel.insert(model)
               // viewModel.setGuestId(model.id)
            }
            withContext(Dispatchers.Main) {

                startActivity(Intent(applicationContext, CadastroRemedios::class.java))
                finish()
            }


        }else{
            withContext(Dispatchers.Main){
                Toast.makeText(applicationContext, "Os campos não pode ser vazios ", Toast.LENGTH_LONG).show()
            }

        }

    }
}