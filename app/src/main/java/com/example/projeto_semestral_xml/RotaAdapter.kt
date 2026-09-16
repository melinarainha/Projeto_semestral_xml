package com.example.projeto_semestral_xml

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class RotaAdapter(
    private val rotas: MutableList<Rota>,
    private val onRemoverClick: (Rota) -> Unit,
    private val onEditarClick: (Rota) -> Unit
) : RecyclerView.Adapter<RotaAdapter.RotaViewHolder>() {

    class RotaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val localSaida: TextView = itemView.findViewById(R.id.tvLocalSaida)
        val localChegada: TextView = itemView.findViewById(R.id.tvLocalChegada)
        val horaSaida: TextView = itemView.findViewById(R.id.tvHoraSaida)
        val horaChegada: TextView = itemView.findViewById(R.id.tvHoraChegada)
        val btnEditar: Button = itemView.findViewById(R.id.btnEditarRota)
        val btnRemover: Button = itemView.findViewById(R.id.btnRemoverRota)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RotaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.lista_rota, parent, false)
        return RotaViewHolder(view)
    }

    override fun onBindViewHolder(holder: RotaViewHolder, position: Int) {
        val rota = rotas[position]
        holder.localSaida.text = "Saída: ${rota.localSaida}"
        holder.localChegada.text = "Chegada: ${rota.localChegada}"
        holder.horaSaida.text = "Hora saída: ${rota.horaSaida}"
        holder.horaChegada.text = "Hora chegada: ${rota.horaChegada}"

        holder.btnRemover.setOnClickListener {
            val pos = holder.adapterPosition
            if (pos != RecyclerView.NO_POSITION) {
                val rotaRemovida = rotas[pos]
                onRemoverClick(rotaRemovida)
                rotas.removeAt(pos)
                notifyItemRemoved(pos)
            }
        }

        holder.btnEditar.setOnClickListener {
            val pos = holder.adapterPosition
            if (pos != RecyclerView.NO_POSITION) {
                onEditarClick(rotas[pos])
            }
        }
    }

    override fun getItemCount(): Int = rotas.size
}
