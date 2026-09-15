package com.example.projeto_semestral_xml

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.projeto_semestral_xml.Carro
import com.example.projeto_semestral_xml.CarroRepository
import java.util.UUID

class CadastroCarroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_veiculos)

        val etModelo = findViewById<EditText>(R.id.etModelo)
        val etPlaca = findViewById<EditText>(R.id.etPlaca)
        val rgTipoCombustivel = findViewById<RadioGroup>(R.id.rgTipoCombustivel)
        val btnSalvar = findViewById<Button>(R.id.btnSalvarCarro)

        btnSalvar?.setOnClickListener {
            val modelo = etModelo.text.toString()
            val placa = etPlaca.text.toString()

            // Identifica o ID do RadioButton selecionado
            val idRadioSelecionado = rgTipoCombustivel.checkedRadioButtonId

            if (modelo.isNotEmpty() && placa.isNotEmpty() && idRadioSelecionado != -1) {
                // Obtém o RadioButton selecionado pelo ID
                val radioSelecionado = findViewById<RadioButton>(idRadioSelecionado)
                val combustivel = radioSelecionado.text.toString()

                val carro = Carro(
                    id = UUID.randomUUID().toString().take(8),
                    modelo = modelo,
                    placa = placa,
                    combustivel = combustivel
                )

                CarroRepository.adicionarCarro(carro)
                Toast.makeText(this, "Veículo cadastrado: $modelo ($combustivel)", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Preencha todos os campos e selecione o combustível!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}