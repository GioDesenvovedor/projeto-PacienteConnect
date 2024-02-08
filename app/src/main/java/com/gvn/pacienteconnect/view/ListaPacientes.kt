package com.gvn.pacienteconnect.view

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.core.view.MenuProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gvn.pacienteconnect.R
import com.gvn.pacienteconnect.adapter.PacienteAdapter
import com.gvn.pacienteconnect.databinding.ActivityListaPacientesBinding
import com.gvn.pacienteconnect.databinding.ItemPacientesBinding
import com.gvn.pacienteconnect.view.listner.OnPacienteListner
import com.gvn.pacienteconnect.viewModel.TdsPacientesViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListaPacientes : AppCompatActivity() {

    private lateinit var binding: ActivityListaPacientesBinding

    private val viewModel: TdsPacientesViewModel by viewModels()
    private val adapterPaci = PacienteAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityListaPacientesBinding.inflate(layoutInflater)


        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //esconder actionBar
        // supportActionBar?.hide()
        window.statusBarColor = Color.parseColor("#FE3942")





        iniciaToolBar()
        initAdaper()
        chamadaViewModel()
        btnVoltar()
        btnAdd()

    }

    private fun iniciaToolBar() {
        binding.materialToolbar.title = "Lista de Pacientess"

        //definir a cor do title
        binding.materialToolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.white))
        binding.materialToolbar.inflateMenu(R.menu.menu_lista_paciente)
        binding.materialToolbar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.pesquisar -> {
                    Toast.makeText(applicationContext, "item pesquisa", Toast.LENGTH_LONG).show()
                    return@setOnMenuItemClickListener true
                }
                R.id.home -> {
                    Toast.makeText(applicationContext, "item home", Toast.LENGTH_LONG).show()
                    return@setOnMenuItemClickListener true
                }
                else -> {
                    true
                }
            }

        }

        //setSupportActionBar(binding.materialToolbar)
    }


    private fun iniciaActionBar() {
        addMenuProvider(
            object : MenuProvider {
                //Exibir  menu na action bar
                override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                    menuInflater.inflate(R.menu.menu_lista_paciente, menu)
                }

                ////seleciona o item do menu para fazer a ação
                override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                    when (menuItem.itemId) {
                        R.id.pesquisar -> {
                            Toast.makeText(applicationContext, "item pesquisa", Toast.LENGTH_LONG)
                                .show()
                        }
                        R.id.home -> {
                            Toast.makeText(applicationContext, "item home", Toast.LENGTH_LONG)
                                .show()
                        }
                    }
                    return true
                }

            }
        )
    }

//    //Exibir  menu na action bar
//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.menu_lista_paciente, menu)
//        return true
//    }
//
//    //seleciona o item do menu para fazer a ação
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when (item.itemId) {
//            R.id.pesquisar -> {
//                Toast.makeText(this, "item pesquisa", Toast.LENGTH_LONG).show()
//            }
//            R.id.home -> {
//                Toast.makeText(this, "item home", Toast.LENGTH_LONG).show()
//            }
//        }
//        return true
//    }

    private fun btnAdd() {
        binding.floatAdd.setOnClickListener {
            startActivity(Intent(this, CadastroActivity::class.java))
            finish()
        }
    }

    private fun btnVoltar() {
        binding.btnVoltar.setOnClickListener {
            onBackPressed()
        }
    }

    private fun chamadaViewModel() {
        Log.d("INFO", "chamadaViewModel called")
        CoroutineScope(Dispatchers.IO).launch {
            viewModel.getAll()
            withContext(Dispatchers.Main) {

                //chama o observador da lista
                observe()
            }

        }
    }

    private fun initAdaper() {

        Log.d("INFO", "initAdapter called")
        //layout
        binding.recyListPac.layoutManager = LinearLayoutManager(application)
        //adapter
        binding.recyListPac.adapter = adapterPaci

        // evento de click
        val listner = object : OnPacienteListner {
            override fun onClick(id: Int) {

                Toast.makeText(applicationContext, "EVENTO CLICADO: $id", Toast.LENGTH_LONG).show()

            }

            override fun OnDelete(id: Int) {
                CoroutineScope(Dispatchers.IO).launch {
                    viewModel.delete(id)
                    viewModel.getAll()
                }
            }


        }
        adapterPaci.attachListner(listner)

    }

    private fun observe() {


        viewModel._listPaci.observe(this) {
            Log.i("INFO", "List size: ${it.size}")
            adapterPaci.updatePaciente(it)
        }


    }

}