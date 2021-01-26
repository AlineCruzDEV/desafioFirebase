package com.digitalhouse.desafiofirebase.jogo.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
    private var listaJogos = ArrayList<Jogo>()

    private lateinit var db: FirebaseFirestore
    private lateinit var cr: CollectionReference

//    val viewModel by viewModels<HomeViewModel>{
//        object : ViewModelProvider.Factory{
//            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//                return HomeViewModel() as T
//            }
//        }
//    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView = binding.rvHomeJogo
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        var jogo1 = Jogo("lol", "2010", "um jogo", "alalalala")
        var jogo2 = Jogo("CS", "2015", "jogo de tiro", "alalalala")

        listaJogos.add(jogo1)
        listaJogos.add(jogo2)
        recyclerView.adapter = JogoAdapter(listaJogos,this)

        binding.fabCadastrarJogo.setOnClickListener {
            callCadastraJogo()
        }


    }

    private fun callCadastraJogo() {
        var intent = Intent(application, CadastraJogoActivity::class.java)
        startActivity(intent)
    }

    fun getListaJogos() {
        var listaAux = ArrayList<Jogo>()
        cr.get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        listaAux.add(Jogo(document.data["nome"].toString(), document.data["ano"].toString(), document.data["descricao"].toString(), document.data["url"].toString()))
                    }
                    listaJogos = listaAux
                } else {
                    Log.w("HomeViewModel", "Exceção ", task.exception)
                }
            }
    }
}