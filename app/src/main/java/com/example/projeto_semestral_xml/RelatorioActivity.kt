package com.example.projeto_semestral_xml

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RelatorioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_relatorio)

        // Usa os dados cadastrados no DataStore (listas globais)
        val recyclerUsuarios = findViewById<RecyclerView>(R.id.recyclerUsuarios)
        recyclerUsuarios.layoutManager = LinearLayoutManager(this)
        recyclerUsuarios.adapter = UsuarioAdapter(
            DataStore.usuarios,
            onRemoverClick = { usuario -> DataStore.usuarios.remove(usuario) },
            onEditarClick = { usuario -> /* lógica de edição */ }
        )

        val recyclerCarros = findViewById<RecyclerView>(R.id.recyclerCarros)
        recyclerCarros.layoutManager = LinearLayoutManager(this)
        recyclerCarros.adapter = CarroAdapter(
            DataStore.carros,
            onRemoverClick = { carro -> DataStore.carros.remove(carro) },
            onEditarClick = { carro -> /* lógica de edição */ }
        )

        val recyclerRotas = findViewById<RecyclerView>(R.id.recyclerRotas)
        recyclerRotas.layoutManager = LinearLayoutManager(this)
        recyclerRotas.adapter = RotaAdapter(
            DataStore.rotas,
            onRemoverClick = { rota -> DataStore.rotas.remove(rota) },
            onEditarClick = { rota -> /* lógica de edição */ }
        )
    }
}
