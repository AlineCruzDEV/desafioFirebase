package com.digitalhouse.desafiofirebase.jogo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.digitalhouse.desafiofirebase.databinding.ActivityCadastraJogoBinding

class CadastraJogoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCadastraJogoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastraJogoBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }
}