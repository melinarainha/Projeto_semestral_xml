package com.example.projeto_semestral_xml

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class CarroAdapter(
    private val carros: MutableList<Carro>,
    private val onRemoverClick: (Carro) -> Unit,
    private val onEditarClick: (Carro) -> Unit
) : RecyclerView.Adapter<CarroAdapter.CarroViewHolder>() {

    class CarroViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val modelo: TextView = itemView.findViewById(R.id.tvModelo)
        val placa: TextView = itemView.findViewById(R.id.tvPlaca)
        val combustivel: TextView = itemView.findViewById(R.id.tvCombustivel)
        val btnEditar: Button = itemView.findViewById(R.id.btnEditarCarro)
        val btnRemover: Button = itemView.findViewById(R.id.btnRemoverCarro)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarroViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.lista_carro, parent, false)
        return CarroViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarroViewHolder, position: Int) {
        val carro = carros[position]
        holder.modelo.text = carro.modelo
        holder.placa.text = "Placa: ${carro.placa}"
        holder.combustivel.text = "Combustível: ${carro.combustivel}"

        holder.btnRemover.setOnClickListener {
            val pos = holder.adapterPosition
            if (pos != RecyclerView.NO_POSITION) {
                val carroRemovido = carros[pos]
                onRemoverClick(carroRemovido)
                carros.removeAt(pos)
                notifyItemRemoved(pos)
            }
        }

        holder.btnEditar.setOnClickListener {
            val pos = holder.adapterPosition
            if (pos != RecyclerView.NO_POSITION) {
                onEditarClick(carros[pos])
            }
        }
    }

    override fun getItemCount(): Int = carros.size
}
