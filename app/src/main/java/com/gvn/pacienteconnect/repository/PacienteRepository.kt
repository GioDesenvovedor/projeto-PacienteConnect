package com.gvn.pacienteconnect.repository

import android.content.Context
import android.util.Log
import com.gvn.pacienteconnect.database.CadPaciente
import com.gvn.pacienteconnect.database.PacienteDataBase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PacienteRepository(context: Context) {
    private val pacienteDataBase = PacienteDataBase.getInstanceDatabase(context).pacienteDao

    suspend fun insert(cadPaciente: CadPaciente): Boolean {
        return pacienteDataBase.insert(cadPaciente) > 0
    }


    suspend fun update(cadPaciente: CadPaciente) {
        return pacienteDataBase.update(cadPaciente)
    }

    suspend fun deleteTodos(): Int {
        return pacienteDataBase.deleteTodos()
    }

    suspend fun getAll(): List<CadPaciente> = withContext(Dispatchers.IO) {

        try {
            return@withContext pacienteDataBase.getAll()
        }catch (e: Exception){
            e.printStackTrace()
            Log.e("INFO", "ERRO AO PEGAR NO REPOSITORY ${hashCode()}")
        }
        return@withContext emptyList()




    }

     fun delete(id: Int) {
         Log.d("INFO", "Repositori chamado para posição: $id remove")
         pacienteDataBase.delete(id)
    }

    suspend fun get(id: Int): CadPaciente {
        return pacienteDataBase.get(id)
    }


}