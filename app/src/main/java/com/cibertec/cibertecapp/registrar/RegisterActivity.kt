package com.cibertec.cibertecapp.registrar

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.cibertec.cibertecapp.R
import com.google.android.material.textfield.TextInputEditText

class RegisterActivity: AppCompatActivity() {

    private lateinit var viewModel: RegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        viewModel = ViewModelProvider(this)[RegisterViewModel::class.java]

        val edtEmail = findViewById<TextInputEditText>(R.id.edtEmail)
        val edtPass = findViewById<TextInputEditText>(R.id.edtPass)
        val btnOpenRegister = findViewById<Button>(R.id.btnOpenRegister)
        btnOpenRegister.setOnClickListener {
            val email = edtEmail.text.toString()
            val pass = edtPass.text.toString()
            viewModel.register(email, pass)
        }
        observableViewModel()
    }

    private fun observableViewModel() {
        viewModel.userRegisterFirebase.observe(this) {
            if (it){
                Toast.makeText(this, "Registro Correcto", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Registro Incorrecto", Toast.LENGTH_SHORT).show()
            }
        }
    }

}