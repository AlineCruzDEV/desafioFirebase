package com.digitalhouse.desafiofirebase.jogo.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.digitalhouse.desafiofirebase.databinding.ActivityHomeBinding
import com.digitalhouse.desafiofirebase.jogo.adapter.JogoAdapter
import com.digitalhouse.desafiofirebase.jogo.entities.Jogo
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    val viewModel by viewModels<HomeViewModel>{
        object : ViewModelProvider.Factory{
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return HomeViewModel() as T
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView = binding.rvHomeJogo
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        viewModel.getListaJogos()

        viewModel.listaJogos.observe(this){
            recyclerView.adapter = JogoAdapter(it, this)
        }

        binding.fabCadastrarJogo.setOnClickListener {
            callCadastraJogo()
        }
    }

    private fun callCadastraJogo() {
        var intent = Intent(application, CadastraJogoActivity::class.java)
        startActivity(intent)
    }


}