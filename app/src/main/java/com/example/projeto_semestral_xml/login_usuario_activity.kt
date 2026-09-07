package com.example.projeto_semestral

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.UUID

class LoginUsuarioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_usuario)

        // Referências aos campos
        val nome = findViewById<EditText>(R.id.etNome)
        val cpf = findViewById<EditText>(R.id.etCpf)
        val senha = findViewById<EditText>(R.id.etSenha)
        val permissoes = findViewById<EditText>(R.id.etPermissoes)

        // Referências aos botões
        val btnCadastrar = findViewById<Button>(R.id.btnCadastrarUsuario)
        val btnLogin = findViewById<Button>(R.id.btnLoginUsuario)
        val btnVerUsuarios = findViewById<Button>(R.id.btnVerUsuarios)

        // Cadastro de usuário
        btnCadastrar.setOnClickListener {
            val idUsuario = UUID.randomUUID().toString().take(8)
            val usuario = Usuario(
                id = idUsuario,
                nome = nome.text.toString(),
                cpf = cpf.text.toString(),
                senha = senha.text.toString(),
                permissoes = permissoes.text.toString()
            )

            UsuarioRepository.adicionarUsuario(usuario)
            Toast.makeText(this, "Usuário cadastrado!\n$usuario", Toast.LENGTH_LONG).show()

// limpa os campos