package com.example.projeto_semestral_xml

object CarroRepository {
    private val listaCarros = mutableListOf<Carro>()

    fun adicionarCarro(carro: Carro) {
        listaCarros.add(carro)
    }

    fun listarCarros(): List<Carro> {
        return listaCarros
    }
}
