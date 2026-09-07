package com.example.projeto_semestral

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UsuarioAdapter(
    private val usuarios: MutableList<Usuario>,
    private val onRemoverClick: (Usuario) -> Unit,
    private val onEditarClick: (Usuario) -> Unit
) : RecyclerView.Adapter<UsuarioAdapter.UsuarioViewHolder>() {

    class UsuarioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nome: TextView = itemView.findViewById(R.id.tvNome)
        val cpf: TextView = itemView.findViewById(R.id.tvCpf)
        val permissoes: TextView = itemView.findViewById(R.id.tvPermissoes)
        val btnRemover: Button = itemView.findViewById(R.id.btnRemover)
        val btnEditar: Button = itemView.findViewById(R.id.btnEditar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsuarioViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.lista_usuario, parent, false)
        return UsuarioViewHolder(view)
    }

    override fun onBindViewHolder(holder: UsuarioViewHolder, position: Int) {
        val usuario = usuarios[position]
        holder.nome.text = usuario.nome
        holder.cpf.text = "CPF: ${usuario.cpf}"
        holder.permissoes.text = "Permissões: ${usuario.permissoes}"

        holder.btnRemover.setOnClickListener {
            onRemoverClick(usuario)
            usuarios.remove(usuario)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, usuarios.size)
        }

        holder.btnEditar.setOnClickListener {
            onEditarClick(usuario)
        }
    }

    override fun getItemCount(): Int = usuarios.size
}
