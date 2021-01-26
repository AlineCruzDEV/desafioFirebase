package com.digitalhouse.desafiofirebase.jogo.ui

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.digitalhouse.desafiofirebase.databinding.ActivityCadastraJogoBinding
import com.digitalhouse.desafiofirebase.jogo.service.cr
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.squareup.picasso.Picasso
import dmax.dialog.SpotsDialog

class CadastraJogoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCadastraJogoBinding
    private lateinit var imagem: String

    private var TAG = "Cadastra Jogo"

    lateinit var alertDialog: AlertDialog
    lateinit var storageReference: StorageReference
    private val CODE_IMG = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastraJogoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        config()

        binding.cvCarregaFoto.setOnClickListener {
            setIntent()
        }

        binding.cvCadastraJogo.btnSaveGame.setOnClickListener {
            var jogo = getData()
            sendJogo(jogo)
        }

    }

    private fun config() {
        alertDialog = SpotsDialog.Builder().setContext(this).build()
        //storageReference = FirebaseStorage.getInstance().getReference()
    }

    private fun setIntent() {
        val intent = Intent()
        intent.type = "image/"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "Upload de Imagem"), CODE_IMG)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == CODE_IMG) {

            storageReference = FirebaseStorage.getInstance().getReference(data.toString())
            val uploadTask = storageReference.putFile(data!!.data!!)

            uploadTask.continueWithTask { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "isSuccessfull", Toast.LENGTH_SHORT).show()
                }
                storageReference!!.downloadUrl
            }.addOnCompleteListener { task ->
                val downloadUri = task.result
                val url = downloadUri!!.toString()
                    .substring(0, downloadUri.toString().indexOf("&token"))

                Log.i("Link Direto", url)
                imagem = url

                alertDialog.dismiss()
            }
        }
    }

    fun getData(): MutableMap<String, Any>{
        val jogo: MutableMap<String, Any> = HashMap()

        jogo["nome"] = binding.cvCadastraJogo.itname.text.toString()
        jogo["ano"] = binding.cvCadastraJogo.itcreated.text.toString()
        jogo["descricao"] = binding.cvCadastraJogo.itdescription.text.toString()
        jogo["url"] = imagem

        return jogo
    }

    fun sendJogo(jogo: MutableMap<String, Any>){
        val nome = binding.cvCadastraJogo.itname.text.toString()

        cr.document(nome).set(jogo).addOnSuccessListener {
            Log.d(TAG, "Sucesso no sendJogo")

        }.addOnFailureListener{
            Log.i(TAG, it.toString())
        }
    }
}