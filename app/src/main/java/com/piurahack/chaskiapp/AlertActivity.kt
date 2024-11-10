package com.piurahack.chaskiapp

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import com.piurahack.chaskiapp.databinding.ActivityMainBinding
import androidx.core.view.WindowInsetsCompat

class AlertActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alert)
        var binding: ActivityMainBinding? = null

        // Inflar el layout con View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configurar el adaptador para el Spinner
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.tipo_incidente_options,
            android.R.layout.simple_spinner_item
        )

        // Especificar el layout cuando se despliegan las opciones
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Asignar el adaptador al Spinner utilizando View Binding
        //binding.tipoIncidenteSpinner.adapter = adapter
    }
}