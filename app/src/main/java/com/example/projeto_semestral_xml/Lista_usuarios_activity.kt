package com.example.projeto_semestral

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListaUsuariosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_usuarios)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerUsuarios)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val usuarios = UsuarioRepository.listarUsuarios().toMutableList()

        val adapter = UsuarioAdapter(
            usuarios,
            onRemoverClick = { usuario ->
                UsuarioRepository.removerUsuario(usuario)
                Toast.makeText(this, "Usuário removido: ${usuario.nome}", Toast.LENGTH_SHORT).show()
            },
            onEditarClick = { usuario ->
                val intent = Intent(this, EditarUsuarioActivity::class.java)
                intent.putExtra("usuarioId", usuario.id)
                startActivity(intent)
            }
        )

        recyclerView.adapter = adapter
    }
}
