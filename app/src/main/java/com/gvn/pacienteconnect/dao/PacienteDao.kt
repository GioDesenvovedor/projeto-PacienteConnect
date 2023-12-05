package com.gvn.pacienteconnect.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.gvn.pacienteconnect.database.CadPaciente
import com.gvn.pacienteconnect.model.PacienteModel

@Dao
interface PacienteDao {

    @Insert
    suspend fun insert(cadPaciente: CadPaciente): Long

    @Update
    suspend fun update(cadPaciente: CadPaciente)


    @Query("DELETE FROM cadpaciente ")
     fun deleteTodos(): Int

    @Query("SELECT * FROM cadpaciente")
     fun getAll(): LiveData<List<CadPaciente>>

    @Query("SELECT * FROM cadpaciente WHERE id = :id")
     fun get(id: Int): CadPaciente



}