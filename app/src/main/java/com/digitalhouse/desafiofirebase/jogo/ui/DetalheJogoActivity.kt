package com.digitalhouse.desafiofirebase.jogo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.digitalhouse.desafiofirebase.databinding.ActivityDetalheJogoBinding
import com.digitalhouse.desafiofirebase.jogo.entities.Jogo
import com.squareup.picasso.Picasso

class DetalheJogoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetalheJogoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalheJogoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val jogo = intent.getSerializableExtra("jogo")
        val ano = intent.getSerializableExtra("ano")
        val descricao = intent.getSerializableExtra("descricao")
        val url = intent.getSerializableExtra("url")

        binding.tvNomeDetalheCapaJogo.text = jogo.toString()
        binding.detalhesJogo.tvNomeDetalheJogo.text = jogo.toString()
        binding.detalhesJogo.tvAnoDetalheJogo.text = ano.toString()
        binding.detalhesJogo.tvDescricaoDetalheJogo.text = descricao.toString()

        Picasso.get().load(url.toString())
            .into(binding.ivImagemDetalheJogo)
    }
}