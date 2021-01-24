package com.digitalhouse.desafiofirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.digitalhouse.desafiofirebase.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.cvLogin.btnLogin.setOnClickListener {
            callHome()
        }

        binding.cvLogin.tvCreateAccout.setOnClickListener {
            callRegister()
        }

    }

    private fun callRegister() {
        var intent = Intent(application, CadastroActivity::class.java)
        startActivity(intent)
    }

    private fun callHome() {
        finishAffinity()
        var intent = Intent(application, HomeActivity::class.java)
        startActivity(intent)
    }
}