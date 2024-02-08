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

    @ColumnInfo(name = "idade")
    var idade : String = ""

    @ColumnInfo(name = "sexo")
    var sexo : Boolean = true

    @ColumnInfo(name = "problema")
    var problema : String = ""

   @ColumnInfo(name = "nomeRemedio")
    var nomeRemedio : String = ""

    @ColumnInfo(name = "dosagem")
    var dosagem : String = ""

    @ColumnInfo(name = "qtDia")
    var quantidadeAoDia : String = ""

    @ColumnInfo(name = "horaMedicacao")
    var horaMedicacao : String = ""


}