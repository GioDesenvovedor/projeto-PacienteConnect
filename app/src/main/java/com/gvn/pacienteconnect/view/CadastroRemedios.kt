package com.gvn.pacienteconnect.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.gvn.pacienteconnect.R
import com.gvn.pacienteconnect.databinding.ActivityCadastroRemediosBinding

class CadastroRemedios : AppCompatActivity() {
    private lateinit var binding: ActivityCadastroRemediosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityCadastroRemediosBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val img = binding.imageView


        val quant = binding.spinnerQt

        // Lista de itens para o Spinner
        val itens = arrayOf("Selecione",
            "1",
            "2",
            "3",
            "4")

        // Cria um adaptador para o Spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, itens)

        // Define o layout para o dropdown do Spinner
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Associa o adaptador ao Spinner
        quant.adapter = adapter


        // Define um ouvinte para o item selecionado no Spinner
        quant.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>, selectedItemView: View, position: Int, id: Long) {
                // Ação a ser executada quando um item é selecionado
                val selectedValue = parentView.getItemAtPosition(position).toString()
                Toast.makeText(applicationContext, "Item selecionado: $selectedValue", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parentView: AdapterView<*>) {
                // Ação a ser executada quando nenhum item é selecionado
            }
        })
    }
}