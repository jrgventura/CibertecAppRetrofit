package com.cibertec.cibertecapp.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.cibertec.cibertecapp.MainActivity
import com.cibertec.cibertecapp.R
import com.cibertec.cibertecapp.registrar.RegisterActivity
import com.google.android.material.textfield.TextInputEditText

class LoginActivity: AppCompatActivity() {

    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        val edtEmail = findViewById<TextInputEditText>(R.id.edtEmail)
        val edtPass = findViewById<TextInputEditText>(R.id.edtPass)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        btnLogin.setOnClickListener {
            val email = edtEmail.text.toString()
            val pass = edtPass.text.toString()
            viewModel.login(email, pass)
        }

        val btnOpenRegister = findViewById<Button>(R.id.btnOpenRegister)
        btnOpenRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        observablesViewModel()
    }

    private fun observablesViewModel() {
        viewModel.userLoginServiceResponse.observe(this) {
            if (it){
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Verifique sus credenciales",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }
}