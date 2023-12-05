package com.gvn.pacienteconnect.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.gvn.pacienteconnect.dao.PacienteDao
import com.gvn.pacienteconnect.database.CadPaciente
import com.gvn.pacienteconnect.database.PacienteDataBase
import com.gvn.pacienteconnect.model.PacienteModel

class PacienteRepository(context: Context) {
    private val pacienteDataBase = PacienteDataBase.getInstanceDatabase(context).pacienteDao

    suspend fun insert(cadPaciente: CadPaciente): Boolean{
        return pacienteDataBase.insert(cadPaciente) > 0
    }


    suspend fun update(cadPaciente: CadPaciente){
        return pacienteDataBase.update(cadPaciente)
    }

    suspend fun deleteTodos(): Int{
        return  pacienteDataBase.deleteTodos()
    }

    suspend fun getAll(): LiveData<List<CadPaciente>>{
        return pacienteDataBase.getAll()
    }

    suspend fun get(id: Int): CadPaciente{
        return pacienteDataBase.get(id)
    }


}