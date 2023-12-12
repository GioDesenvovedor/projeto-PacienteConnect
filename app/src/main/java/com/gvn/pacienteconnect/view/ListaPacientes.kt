package com.gvn.pacienteconnect.view

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gvn.pacienteconnect.adapter.PacienteAdapter
import com.gvn.pacienteconnect.databinding.ActivityListaPacientesBinding
import com.gvn.pacienteconnect.databinding.ItemPacientesBinding
import com.gvn.pacienteconnect.viewModel.TdsPacientesViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListaPacientes : AppCompatActivity() {

    private lateinit var binding: ActivityListaPacientesBinding
    private val viewModel: TdsPacientesViewModel by viewModels()
    private val adapterPaci = PacienteAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("INFO", "onCreate chamadaListActiv")
        binding = ActivityListaPacientesBinding.inflate(layoutInflater)


        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //esconder actionBar
        supportActionBar?.hide()
        window.statusBarColor = Color.parseColor("#FE3942")

        //Layout Recycler

        initAdaper()
        chamadaViewModel()
        observe()

    }

    private fun chamadaViewModel() {
        Log.d("INFO", "chamadaViewModel called")
        CoroutineScope(Dispatchers.IO).launch {
            viewModel.getAll()
        }
    }

    private fun initAdaper() {
        CoroutineScope(Dispatchers.IO).launch {
            Log.d("INFO", "initAdapter called")
            //layout
            binding.recyListPac.layoutManager = LinearLayoutManager(application)
            //adapter
            binding.recyListPac.adapter = adapterPaci
        }


    }

    private fun observe() {


            viewModel._listPaci.observe(this) {
                Log.i("INFO", "List size: ${it.size}")
                adapterPaci.updatePaciente(it)
            }




    }

}