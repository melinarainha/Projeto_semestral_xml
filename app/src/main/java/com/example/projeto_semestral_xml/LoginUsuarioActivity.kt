package com.example.projeto_semestral_xml

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginUsuarioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_usuario) // confirme o nome do XML

        val etNome = findViewById<EditText>(R.id.etNome)
        val etSenha = findViewById<EditText>(R.id.etSenha)
        val btnLoginUsuario = findViewById<Button>(R.id.btnLoginUsuario)

        btnLoginUsuario.setOnClickListener {
            val nome = etNome.text.toString()
            val senha = etSenha.text.toString()

            // Verifica se existe usuário com esse nome e senha
            val usuario = DataStore.usuarios.find { it.nome == nome && it.senha == senha }

            if (usuario != null) {
                Toast.makeText(this, "Login realizado com sucesso!", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, HomeActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Nome ou senha inválidos!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
