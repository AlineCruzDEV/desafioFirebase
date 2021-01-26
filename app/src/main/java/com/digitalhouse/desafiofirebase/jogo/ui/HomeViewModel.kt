package com.digitalhouse.desafiofirebase.jogo.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.digitalhouse.desafiofirebase.jogo.entities.Jogo
import com.digitalhouse.desafiofirebase.jogo.service.cr

class HomeViewModel(): ViewModel() {

    var listaJogos = MutableLiveData<ArrayList<Jogo>>()

    fun getListaJogos() {
        var listaAux = ArrayList<Jogo>()
        cr.get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        listaAux.add(Jogo(document.data["nome"].toString(), document.data["ano"].toString(), document.data["descricao"].toString(), document.data["url"].toString()))
                    }
                    listaJogos.value = listaAux
                } else {
                    Log.w("HomeViewModel", "Exceção ", task.exception)
                }
            }
    }
}

