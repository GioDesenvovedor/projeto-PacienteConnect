package com.gvn.pacienteconnect.viewModel

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.gvn.pacienteconnect.database.CadPaciente
import com.gvn.pacienteconnect.repository.PacienteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TdsPacientesViewModel(application: Application) :
    AndroidViewModel(application) {
    private val repository = PacienteRepository(application)

    private val listPaciente = MutableLiveData<List<CadPaciente>>()
    val _listPaci: LiveData<List<CadPaciente>> = listPaciente

    private val paciente = MutableLiveData<CadPaciente>()
    val _paci: LiveData<CadPaciente> = paciente

    private val nomePaci = MutableLiveData<String>()
    val _snomePaci: LiveData<String> = nomePaci


    suspend fun getAll() {
        viewModelScope.launch {
            try {
                withContext(Dispatchers.Main) {
                    listPaciente.value = repository.getAll()
                    Log.d("INFO", "onCreateViewHolder adapter CRIADO")
                }
            } catch (e: Exception) {
                Log.i("TAG", "ERRO AO SALVAR: ${e.message}, ")
                withContext(Dispatchers.Main) {

                }


            }

        }
    }

    fun delete(id: Int){
        repository.delete(id)
    }

}