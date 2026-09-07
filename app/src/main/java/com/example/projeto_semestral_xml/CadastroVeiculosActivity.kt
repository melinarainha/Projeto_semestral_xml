package com.example.projeto_semestral_xml

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CadastroVeiculosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_veiculos)

        val tituloVeiculos = findViewById<TextView>(R.id.tvCadastroVeiculos)
        tituloVeiculos.text = getString(R.string.cadastro_veiculos)
    }
}
