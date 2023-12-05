package com.gvn.pacienteconnect.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.gvn.pacienteconnect.dao.PacienteDao

@Database(entities = [CadPaciente::class], version = 1)
abstract class PacienteDataBase() : RoomDatabase() {

    abstract val pacienteDao: PacienteDao

    companion object{
        @Volatile
        private var INSTANCE: PacienteDataBase? = null


        fun getInstanceDatabase(context: Context): PacienteDataBase {
            synchronized(this) {
                var instance: PacienteDataBase? = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        PacienteDataBase::class.java, "pacienteDB"
                    ).build()
                }
                return instance
            }

        }


    }



}