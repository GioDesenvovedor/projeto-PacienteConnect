package com.gvn.pacienteconnect.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.gvn.pacienteconnect.database.CadPaciente
import com.gvn.pacienteconnect.repository.PacienteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CadRemedioViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = PacienteRepository(application)

    suspend fun insert(cadPaciente: CadPaciente): Boolean = withContext(Dispatchers.IO) {
        try {
            repository.insert(cadPaciente)
            true
        } catch (e: Exception) {
            Log.i(
                "TAG", "Erro ao inserir dados dos remedios: ${hashCode()}"
            )
            false
        }

    }

    suspend fun update(cadPaciente: CadPaciente) {
        repository.update(cadPaciente)
    }

    suspend fun deleteTodos() {
        repository.deleteTodos()
    }

    suspend fun get(id: Int): CadPaciente {
        return repository.get(id)
    }
}