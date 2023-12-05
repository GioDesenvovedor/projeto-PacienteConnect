package com.gvn.pacienteconnect.view

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.gvn.pacienteconnect.databinding.ActivityLisaPacientesBinding
import com.gvn.pacienteconnect.viewModel.CadPacienteViewModel
import com.gvn.pacienteconnect.viewModel.TdsPacientesViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LisaPacientes : AppCompatActivity() {

    private lateinit var binding: ActivityLisaPacientesBinding
    private val viewModel : TdsPacientesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLisaPacientesBinding.inflate(layoutInflater)


        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //esconder actionBar
        supportActionBar?.hide()
        window.statusBarColor = Color.parseColor("#FE3942")
        CoroutineScope(Dispatchers.Main).launch{
            observe()
        }

    }

    private suspend fun observe() {

    }

}