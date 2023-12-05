package com.gvn.pacienteconnect.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.gvn.pacienteconnect.database.CadPaciente
import com.gvn.pacienteconnect.repository.PacienteRepository

class TdsPacientesViewModel(application: Application):
    AndroidViewModel(application) {
        private val  repository = PacienteRepository(application)

    suspend fun getAll(): LiveData<List<CadPaciente>> {
       return repository.getAll()
    }



}