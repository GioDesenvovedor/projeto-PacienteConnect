package com.gvn.pacienteconnect.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.gvn.pacienteconnect.database.CadPaciente

@Dao
interface PacienteDao {

    @Insert
    suspend fun insert(cadPaciente: CadPaciente): Long

    @Update
    suspend fun update(cadPaciente: CadPaciente)


    @Query("DELETE FROM cadpaciente ")
     fun deleteTodos(): Int

    @Query("SELECT * FROM cadpaciente")
     fun getAll(): List<CadPaciente>

    @Query("SELECT * FROM cadpaciente WHERE id = :id")
     fun get(id: Int): CadPaciente



}