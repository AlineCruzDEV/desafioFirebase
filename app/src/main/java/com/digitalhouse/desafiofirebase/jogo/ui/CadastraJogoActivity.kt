package com.digitalhouse.desafiofirebase.jogo.ui

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.digitalhouse.desafiofirebase.databinding.ActivityCadastraJogoBinding
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

class CadastraJogoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCadastraJogoBinding

    private lateinit var db: FirebaseFirestore
    private lateinit var cr: CollectionReference
    private var TAG = "Cadastra Jogo"

    lateinit var alertDialog: AlertDialog
    lateinit var storageReference: StorageReference
    private val CODE_IMG = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastraJogoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        config()


    }

    fun config(){
        db = FirebaseFirestore.getInstance()
        cr = db.collection("produtos")
    }

}