package com.example.projeto_semestral_xml

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CadastroRotaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Vincula ao layout corrigido
        setContentView(R.layout.cadastro_rota_corrigido)

        // Referências aos campos do XML
        val edtLocalSaida = findViewById<EditText>(R.id.edtLocalSaida)
        val edtLocalChegada = findViewById<EditText>(R.id.edtLocalChegada)
        val edtHoraSaida = findViewById<EditText>(R.id.edtHoraSaida)
        val edtHoraChegada = findViewById<EditText>(R.id.edtHoraChegada)
        val btnSalvar = findViewById<Button>(R.id.btnSalvar)

        // Ação do botão
        btnSalvar.setOnClickListener {
            val localSaida = edtLocalSaida.text.toString()
            val localChegada = edtLocalChegada.text.toString()
            val horaSaida = edtHoraSaida.text.toString()
            val horaChegada = edtHoraChegada.text.toString()

            // Exemplo de validação simples
            if (localSaida.isEmpty() || localChegada.isEmpty() ||
                horaSaida.isEmpty() || horaChegada.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Rota salva:\n$localSaida → $localChegada\n$horaSaida → $horaChegada", Toast.LENGTH_LONG).show()
            }
        }
    }
}
