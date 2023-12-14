package com.gvn.pacienteconnect.view.viewHolder

import android.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.gvn.pacienteconnect.database.CadPaciente
import com.gvn.pacienteconnect.databinding.ItemPacientesBinding
import com.gvn.pacienteconnect.view.listner.OnPacienteListner


class PacienteViewHolder(
    // Defini o binding para acesso ao card com os textos e define o listner pra eventos na listagem
    private val itemVi: ItemPacientesBinding, private val listner: OnPacienteListner
) :
    RecyclerView.ViewHolder(itemVi.root) {
    fun bindViewHolder(item: CadPaciente) {

        itemVi.cardPaciente
        itemVi.textN.text = item.nome
        itemVi.textSobN.text = item.sobrenome
        itemVi.textD.text = item.problema


        //evento de click no card da lista
        itemVi.cardPaciente.setOnClickListener {
            listner.onClick(item.id)
        }
        //evento de click longo no card da lista para deletar
        itemVi.cardPaciente.setOnLongClickListener {

            AlertDialog.Builder(itemView.context)
                .setTitle("Remoção do Paciente na Lista")
                .setMessage("Tem certeza que deseja remover o Paciente ${item.nome} ${item.sobrenome} da lista  ? ")
                .setPositiveButton("Sim") { dialog, wich ->
                    listner.OnDelete(item.id)
                }
                    // se o usuario dizer não, sera null
                .setNegativeButton("Não", null)
                .create()
                .show()

            true
        }
    }
}