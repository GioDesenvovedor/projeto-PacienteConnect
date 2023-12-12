package com.gvn.pacienteconnect.view.viewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.gvn.pacienteconnect.database.CadPaciente
import com.gvn.pacienteconnect.databinding.ItemPacientesBinding

 class PacienteViewHolder(
    // Defini o binding para acesso ao card com os textos
    private val itemVi: ItemPacientesBinding
) :
    RecyclerView.ViewHolder(itemVi.root) {
        fun bindViewHolder(item : CadPaciente){

            itemVi.cardPaciente
            itemVi.textNome.text = item.nome
            itemVi.textSobrenome.text = item.sobrenome
            itemVi.textDiagnostico.text = item.problema
        }
}