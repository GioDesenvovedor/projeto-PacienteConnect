package com.gvn.pacienteconnect.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CadPaciente")
class CadPaciente {



    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0

    @ColumnInfo(name = "nome")
    var nome : String = ""

    @ColumnInfo(name = "sobrenome")
    var sobrenome : String = ""

    @ColumnInfo(name = "problema")
    var problema : String = ""

    @ColumnInfo(name = "remedioComprimdo")
    var remedioComprimdo : String = ""

    @ColumnInfo(name = "remedioMl")
    var remedioMl : String = ""
}