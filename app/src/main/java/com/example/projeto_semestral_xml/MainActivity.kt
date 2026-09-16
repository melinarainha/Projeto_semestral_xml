package com.example.projeto_semestral_xml

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCadastraUsuario = findViewById<Button>(R.id.btnCadastraUsuario)
        val btnLoginUsuario = findViewById<Button>(R.id.btnLogin)

        // Cadastra Usuario
        btnCadastraUsuario.setOnClickListener {
            startActivity(Intent(this, CadastraUsuarioActivity::class.java))
        }
        // Seleciona Login Usuário
        btnLoginUsuario.setOnClickListener {
            startActivity(Intent(this, LoginUsuarioActivity::class.java))
        }
    }
}