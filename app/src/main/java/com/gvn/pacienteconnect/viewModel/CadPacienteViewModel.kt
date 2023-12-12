package com.gvn.pacienteconnect.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.gvn.pacienteconnect.database.CadPaciente
import com.gvn.pacienteconnect.repository.PacienteRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CadPacienteViewModel(application: Application): AndroidViewModel(application) {

    private val repository = PacienteRepository(application)

    private val cadPaciente = MutableLiveData<CadPaciente>()
    val _cadP: LiveData<CadPaciente> = cadPaciente

    private val savePaciente = MutableLiveData<String>()
    val _savePaciente : LiveData<String> = savePaciente

    suspend fun insert(cadPaciente: CadPaciente): Boolean = withContext(Dispatchers.IO){
          try {
                repository.insert(cadPaciente)

            true
        }catch (e:Exception){
            Log.i("TAG", "Erro ao inserir os dados: ${hashCode()}")
            false
        }


    }


    suspend fun update(cadPaciente: CadPaciente){
       repository.update(cadPaciente)
    }

    suspend fun deleteTodos(){
        repository.deleteTodos()
    }

    suspend fun get(id: Int): CadPaciente{
        return repository.get(id)
    }

    /*suspend fun getAll(): LiveData<List<CadPaciente>>{
        repository.getAll()
    }

    suspend fun get(id: Int): CadPaciente{
       repository.get(id)
    }

    fun savePac(cadPaciente: CadPaciente){

    }*/
}