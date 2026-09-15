package com.example.projeto_semestral_xml  // confirme se bate com o AndroidManifest.xml

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.projeto_semestral.Usuario
import kotlin.let
import kotlin.collections.find

class EditarUsuarioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar_usuario)

        // Recupera o ID do usuário enviado pela ListaUsuariosActivity
        val usuarioId = intent.getStringExtra("usuarioId")
        //val usuario = UsuarioRepository.listarUsuarios().find { it.id == usuarioId }

        // Referências aos campos da tela
        val etNome = findViewById<EditText>(R.id.etNomeEditar)
        val etCpf = findViewById<EditText>(R.id.etCpfEditar)
        val etSenha = findViewById<EditText>(R.id.etSenhaEditar)
        val etPermissoes = findViewById<EditText>(R.id.etPermissoesEditar)
        val btnSalvar = findViewById<Button>(R.id.btnSalvarEdicao)

        // Preenche os campos com os dados atuais do usuário
        Usuario.let {
            etNome.setText(it.nome)
            etCpf.setText(it.cpf)
            etSenha.setText(it.senha)
            etPermissoes.setText(it.permissoes)
        }

        // Clique no botão salvar
        btnSalvar.setOnClickListener {
            Usuario.let {
                val usuarioAtualizado = Usuario(
                    id = it.id.toString(),
                    nome = etNome.text.toString(),
                    cpf = etCpf.text.toString(),
                    senha = etSenha.text.toString(),
                    permissoes = etPermissoes.text.toString()
                )
                UsuarioRepository.atualizarUsuario(usuarioAtualizado)
                Toast.makeText(this, "Usuário atualizado com sucesso!", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }
}
