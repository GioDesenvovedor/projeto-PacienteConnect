package com.gvn.pacienteconnect.view

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.view.isVisible
import com.gvn.pacienteconnect.R
import com.gvn.pacienteconnect.databinding.ActivityCadastroRemediosBinding

class CadastroRemedios : AppCompatActivity() {
    private lateinit var binding: ActivityCadastroRemediosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityCadastroRemediosBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //esconder actionBar
        supportActionBar?.hide()
        window.statusBarColor = Color.parseColor("#FE3942")

        //esconder os Spinners
        binding.spinnerComp.isVisible = false
        binding.spinnerDose.isVisible = false

        /*  tarefas a fazer

        * coloca um botão adicionar mais remedios
        * criar classe para salvar remedios no banco **/


        radChecCompr()
        radChecMl()
        btnsaveRene()



    }

    // Ao selecionar o radio botton miligrama dispara o evento loadSpinner2
    private fun radChecMl() {
        binding.radMl.setOnCheckedChangeListener { compoundButton, ml ->
            if (ml) {
                loadSpinner2()
            }
        }
    }

    //Ao selecionar o radio botton comprimido dispara o evento loadSpinner
    private fun radChecCompr() {
        binding.radComp.setOnCheckedChangeListener { compoundButton, comprimido ->
            if (comprimido) {
                loadSpinner()
            }
        }
    }

    private fun loadSpinner() {
        //esconder o spinner dose
        binding.spinnerDose.isVisible = false

        //carregar o spinner comprimido
        binding.spinnerComp.isVisible = true
        loadComprimidos()
        loadSpinner3()
    }

    private fun loadComprimidos() {
        // Lista de itens para o Spinner
        val itens = listOf(
            "Quantos comprimidos", "1 comprimido", "2 comprimido", "3 comprimido",
            "4 comprimido", "5 comprimido", "6 comprimido"
        )

        // Cria um adaptador para o Spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, itens)

        // Associa o adaptador ao Spinner
        val quant = binding.spinnerComp
        quant.adapter = adapter
    }

    private fun loadSpinner2() {
        // esconde o spinner comprimido
        binding.spinnerComp.isVisible = false

        // carregar o spinner doseMl
        binding.spinnerDose.isVisible = true
        loadDoseMl()
        loadSpinner3()
    }

    private fun loadDoseMl() {

        // Lista de itens para o Spinner
        val itens = listOf("Quantos MLs", "1 ml", "1,5 ml","2 ml","2,5 ml", "3 ml","3,5 ml", "4 ml")

        // Cria um adaptador para o Spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, itens)

        // Associa o adaptador ao Spinner
        val quant = binding.spinnerDose
        quant.adapter = adapter
    }

    private fun loadSpinner3() {
        // Lista de itens para o Spinner
        val itens = listOf("Selecione", "1 vez", "2 vezes", "3 vezes", "4 vezes")

        // Cria um adaptador para o Spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, itens)

        // Associa o adaptador ao Spinner
        val quant = binding.qtVezezAodia
        quant.adapter = adapter
    }

    private fun btnsaveRene() {
        binding.btnRemedio.setOnClickListener {
            startActivity(Intent(this, ListaPacientes::class.java))
        }
    }
}