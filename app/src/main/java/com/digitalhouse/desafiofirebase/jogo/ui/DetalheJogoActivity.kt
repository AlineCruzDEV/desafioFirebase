package com.digitalhouse.desafiofirebase.jogo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.digitalhouse.desafiofirebase.databinding.ActivityDetalheJogoBinding
import com.digitalhouse.desafiofirebase.jogo.entities.Jogo

class DetalheJogoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetalheJogoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalheJogoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val jogo = intent.getSerializableExtra("jogo") as Jogo

        Log.i("DetalheJogo", jogo.nome.toString())
    }
}