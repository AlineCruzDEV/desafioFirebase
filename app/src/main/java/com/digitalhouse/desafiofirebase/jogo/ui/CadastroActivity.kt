package com.digitalhouse.desafiofirebase.jogo.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.digitalhouse.desafiofirebase.databinding.ActivityCadastroBinding

class CadastroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCadastroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.cvCadastro.btnCreateAccount.setOnClickListener {
            callHome()
        }
    }
    private fun callHome() {
        finishAffinity()
        var intent = Intent(application, HomeActivity::class.java)
        startActivity(intent)
    }
}