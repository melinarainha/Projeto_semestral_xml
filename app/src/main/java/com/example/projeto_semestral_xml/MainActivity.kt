package com.example.projeto_semestral_xml

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCarro = findViewById<Button>(R.id.btnCarro)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        // Seleciona Cadastrar Carro
        btnCarro.setOnClickListener {
            startActivity(Intent(this, CadastroCarroActivity::class.java))
        }

        // Seleciona Login Usuário
        btnLogin.setOnClickListener {
            startActivity(Intent(this, LoginUsuarioActivity::class.java))
        }
    }
}