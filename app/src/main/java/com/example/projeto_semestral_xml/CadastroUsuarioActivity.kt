package com.example.projeto_semestral_xml

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CadastroUsuarioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_usuario)

        val etNome = findViewById<EditText>(R.id.etNome)
        val etCpf = findViewById<EditText>(R.id.etCpf)
        val etPermissoes = findViewById<EditText>(R.id.etPermissoes)
        val etSenha = findViewById<EditText>(R.id.etSenha)
        val btnCadastrarUsuario = findViewById<Button>(R.id.btnCadastrarUsuario)

        btnCadastrarUsuario.setOnClickListener {
            val usuario = Usuario(
                id = DataStore.usuarios.size + 1, // gera id incremental
                nome = etNome.text.toString(),
                cpf = etCpf.text.toString(),
                permissoes = etPermissoes.text.toString(),
                senha = etSenha.text.toString()
            )

            DataStore.usuarios.add(usuario)

            Toast.makeText(this, "Usuário cadastrado!\n$usuario", Toast.LENGTH_LONG).show()

            // Volta para a tela principal
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}
