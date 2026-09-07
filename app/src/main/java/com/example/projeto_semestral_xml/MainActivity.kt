package com.example.projeto_semestral

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var escolha: String? = null  // guarda a escolha do usuário

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCarro = findViewById<Button>(R.id.btnCarro)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val btnIniciar = findViewById<Button>(R.id.btnIniciar)

        // Seleciona Cadastrar Carro
        btnCarro.setOnClickListener {
            escolha = "carro"
            btnCarro.setBackgroundColor(Color.parseColor("#388E3C")) // verde escuro
            btnLogin.setBackgroundColor(Color.parseColor("#2196F3")) // volta ao azul padrão
            Toast.makeText(this, "Cadastrar Carro selecionado", Toast.LENGTH_SHORT).show()
        }

        // Seleciona Login Usuário
        btnLogin.setOnClickListener {
            escolha = "login"
            btnLogin.setBackgroundColor(Color.parseColor("#1565C0")) // azul escuro
            btnCarro.setBackgroundColor(Color.parseColor("#4CAF50")) // volta ao verde padrão
            Toast.makeText(this, "Login Usuário selecionado", Toast.LENGTH_SHORT).show()
        }

        // Inicia conforme a escolha
        btnIniciar.setOnClickListener {
            when (escolha) {
                "carro" -> startActivity(Intent(this, CadastroCarroActivity::class.java))
                "login" -> startActivity(Intent(this, LoginUsuarioActivity::class.java))
                else -> Toast.makeText(this, "Selecione uma opção antes de iniciar", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
