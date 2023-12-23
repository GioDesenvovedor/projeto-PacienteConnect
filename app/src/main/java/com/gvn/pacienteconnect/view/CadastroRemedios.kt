package com.gvn.pacienteconnect.view

import android.app.TimePickerDialog
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.view.isVisible
import com.gvn.pacienteconnect.R
import com.gvn.pacienteconnect.databinding.ActivityCadastroRemediosBinding
import java.text.Format
import java.time.format.FormatStyle
import java.util.Calendar

class CadastroRemedios : AppCompatActivity() {
    private lateinit var binding: ActivityCadastroRemediosBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityCadastroRemediosBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //esconder actionBar
        supportActionBar?.hide()
        window.statusBarColor = Color.parseColor("#FE3942")

        //esconder os Spinners
        binding.spinnerComp.isVisible = false
        binding.spinnerDose.isVisible = false

        /*  tarefas a fazer


        * criar classe para salvar remedios no banco **/


        radChecCompr()
        radChecMl()
        btnsaveRene()
        timerPi()

    }
    private fun timerPi() {
       binding.editTextTime.setOnClickListener {
           alertaTimer()
       }
    }


    //Evento hora do remédio, disparar alarme
    private fun alertaTimer() {
        val alarme = binding.editTextTime

        val calendar = Calendar.getInstance() // Obtém uma instância do objeto Calendar configurada com a data e a hora atuais
        val currentHor = calendar.get(Calendar.HOUR_OF_DAY) // Obtém a hora atual no formato de 24 horas
        val currentMinu = calendar.get(Calendar.MINUTE) // Obtém a hora atual no formato de 24 horas
        
        val timePickerDialog = TimePickerDialog(this,TimePickerDialog.OnTimeSetListener { timePicker, horaDia, minutos ->

            // Ouvinte chamado quando o usuário define o tempo no seletor de tempo
            val selectedTime = "$horaDia:$minutos"
            alarme.text = selectedTime // Atualiza o TextClock com o tempo selecionado

            // Aqui você pode implementar a lógica para definir um alarme ou lembrete com o tempo selecionado

        }, currentHor,// Hora inicial para o seletor de tempo
            currentMinu,// Minuto inicial para o seletor de tempo
            true)// Indica se o seletor de tempo deve usar o formato de 24 horas (true) ou AM/PM (false)

        timePickerDialog.show()// Exibe o seletor de tempo

        val remedio = binding.editRemedio.toString().trim()
        binding.switchAlarm.setOnCheckedChangeListener { button, sw ->
            if (sw){

                val  intent = Intent(AlarmClock.ACTION_SET_ALARM)
                intent.putExtra(AlarmClock.EXTRA_HOUR, alarme.text.toString().split(":")[0].toInt())
                intent.putExtra(AlarmClock.EXTRA_MINUTES, alarme.text.toString().split(":")[1].toInt())
                intent.putExtra(AlarmClock.EXTRA_MESSAGE, getString(R.string.alarme_remedio))
                startActivity(intent)

                if (intent.resolveActivity(packageManager)!= null){
                    startActivity(intent)
                }
            }
        }
    }

    // Ao selecionar o radio botton miligrama dispara o evento loadSpinner2
    private fun radChecMl() {
        binding.radMl.setOnCheckedChangeListener { compoundButton, ml ->
            if (ml) {
                loadSpinner2()
            }
        }
    }

    //Ao selecionar o radio botton comprimido dispara o evento loadSpinner
    private fun radChecCompr() {
        binding.radComp.setOnCheckedChangeListener { compoundButton, comprimido ->
            if (comprimido) {
                loadSpinner()
            }
        }
    }

    private fun loadSpinner() {
        //esconder o spinner dose
        binding.spinnerDose.isVisible = false

        //carregar o spinner comprimido
        binding.spinnerComp.isVisible = true
        loadComprimidos()
        loadSpinner3()
    }

    private fun loadComprimidos() {
        // Lista de itens para o Spinner
        val itens = listOf(
            "Quantos comprimidos", "1 comprimido", "2 comprimido", "3 comprimido",
            "4 comprimido", "5 comprimido", "6 comprimido"
        )

        // Cria um adaptador para o Spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, itens)

        // Associa o adaptador ao Spinner
        val quant = binding.spinnerComp
        quant.adapter = adapter
    }

    private fun loadSpinner2() {
        // esconde o spinner comprimido
        binding.spinnerComp.isVisible = false

        // carregar o spinner doseMl
        binding.spinnerDose.isVisible = true
        loadDoseMl()
        loadSpinner3()
    }

    private fun loadDoseMl() {

        // Lista de itens para o Spinner
        val itens = listOf("Quantos MLs", "1 ml", "1,5 ml","2 ml","2,5 ml", "3 ml","3,5 ml", "4 ml")

        // Cria um adaptador para o Spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, itens)

        // Associa o adaptador ao Spinner
        val quant = binding.spinnerDose
        quant.adapter = adapter
    }

    private fun loadSpinner3() {
        // Lista de itens para o Spinner
        val itens = listOf("Selecione", "1 vez", "2 vezes", "3 vezes", "4 vezes")

        // Cria um adaptador para o Spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, itens)

        // Associa o adaptador ao Spinner
        val quant = binding.qtVezezAodia
        quant.adapter = adapter
    }

    private fun btnsaveRene() {
        binding.btnRemedio.setOnClickListener {
            startActivity(Intent(this, ListaPacientes::class.java))
        }
    }
}