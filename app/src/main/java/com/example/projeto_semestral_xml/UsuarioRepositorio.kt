package com.example.projeto_semestral_xml

object UsuarioRepository {
    // Lista em memória para armazenar usuários
    private val usuarios = mutableListOf<Usuario>()

    // Adicionar novo usuário
    fun adicionarUsuario(usuario: Usuario) {
        usuarios.add(usuario)
    }

    // Listar todos os usuários
    fun listarUsuarios(): List<Usuario> {
        return usuarios.toList() // retorna cópia imutável
    }

    // Autenticar usuário pelo CPF e senha
    fun autenticar(cpf: String, senha: String): Usuario? {
        return usuarios.find { it.cpf == cpf && it.senha == senha }
    }

    // Remover usuário
    fun removerUsuario(usuario: Usuario) {usuarios.removeIf { it.id == usuario.id } }

    // Atualizar dados de um usuário existente
    fun atualizarUsuario(usuarioAtualizado: Usuario) {
        val index = usuarios.indexOfFirst { it.id == usuarioAtualizado.id }
        if (index != -1) {
            usuarios[index] = usuarioAtualizado
        }
    }

    // Buscar usuário pelo CPF
    fun buscarPorNome(nome: String): Usuario? {
        return usuarios.find { it.nome == nome }
    }
}
