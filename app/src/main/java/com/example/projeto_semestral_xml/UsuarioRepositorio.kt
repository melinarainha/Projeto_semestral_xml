object UsuarioRepository {
    private val listaUsuarios = mutableListOf<Usuario>()

    fun adicionarUsuario(usuario: Usuario) {
        listaUsuarios.add(usuario)
    }

    fun listarUsuarios(): List<Usuario> {
        return listaUsuarios
    }

    fun autenticar(cpf: String, senha: String): Usuario? {
        return listaUsuarios.find { it.cpf == cpf && it.senha == senha }
    }

    fun removerUsuario(usuario: Usuario) {
        listaUsuarios.remove(usuario)
    }

    fun atualizarUsuario(usuarioAtualizado: Usuario) {
        val index = listaUsuarios.indexOfFirst { it.id == usuarioAtualizado.id }
        if (index != -1) {
            listaUsuarios[index] = usuarioAtualizado
        }
    }
}
