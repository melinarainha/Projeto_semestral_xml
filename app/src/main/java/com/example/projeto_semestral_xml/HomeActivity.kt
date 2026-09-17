package com.example.projeto_semestral_xml

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val btnCarro = findViewById<Button>(R.id.btnCarro)
        val btnRota = findViewById<Button>(R.id.btnRota)
        val btnRelatorio = findViewById<Button>(R.id.btnRelatorio)

        // Seleciona Cadastrar Carro
        btnCarro.setOnClickListener {
            startActivity(Intent(this, CadastroCarroActivity::class.java))
        }

        // Seleciona Rota
        btnRota.setOnClickListener {
            startActivity(Intent(this, CadastroRotaActivity::class.java))
        }

        //
        btnRelatorio.setOnClickListener {
            startActivity(Intent(this, RelatorioActivity::class.java))
        }
    }
}