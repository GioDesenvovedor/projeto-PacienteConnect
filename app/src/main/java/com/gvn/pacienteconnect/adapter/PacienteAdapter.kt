package com.gvn.pacienteconnect.adapter

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.gvn.pacienteconnect.R
import com.gvn.pacienteconnect.database.CadPaciente
import com.gvn.pacienteconnect.databinding.ItemPacientesBinding
import com.gvn.pacienteconnect.view.MainActivity
import com.gvn.pacienteconnect.view.listner.OnPacienteListner
import com.gvn.pacienteconnect.view.viewHolder.PacienteViewHolder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class PacienteAdapter: RecyclerView.Adapter<PacienteViewHolder>() {

    private var lisPaciente: List<CadPaciente> = listOf()
    private lateinit var listner: OnPacienteListner

    // Outro metodo para ViewHolder
   // inner class PacViewholder(val binding: ItemPacientesBinding) :
       // RecyclerView.ViewHolder(binding.root) {

   // }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PacienteViewHolder {
        Log.d("INFO", "onCreateViewHolder adapter CRIADO")
        val itemP = ItemPacientesBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)




        return PacienteViewHolder(itemP,listner)
    }

    override fun onBindViewHolder(holder: PacienteViewHolder, position: Int) {
        Log.d("INFO", "onBindViewHolder chamado para posição: $position")

        /*val recyclerPaci = lisPaciente[position]
        holder.binding.cardPaciente
        holder.binding.textN.text = recyclerPaci.nome
        holder.binding.textSobN.text = recyclerPaci.sobrenome
        holder.binding.textD.text = recyclerPaci.problema*/

         holder.bindViewHolder(lisPaciente[position])

    }



    override fun getItemCount(): Int {
        Log.d("INFO", "obter contagem de itens chamada:  listar   ${lisPaciente.size}")
        return lisPaciente.size
    }

    fun updatePaciente(list: List<CadPaciente>) {
        Log.d("INFO", "updatePaciente called with list size: ${list.size}")
        lisPaciente = list
        notifyDataSetChanged()

    }

    fun attachListner(pacientelistner: OnPacienteListner){
        listner = pacientelistner
    }
}