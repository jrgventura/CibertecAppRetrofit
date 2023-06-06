package com.cibertec.cibertecapp.registrar

import android.app.Activity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

data class UsuarioFirestore (
    var correo: String
)

class RegisterViewModel: ViewModel() {

    private lateinit var auth: FirebaseAuth
    private lateinit var firestore: FirebaseFirestore
    val userRegisterFirebase = MutableLiveData<Boolean>()
    fun register(email: String, pass: String) {
        registerFirebase(email, pass)
    }
    private fun registerFirebase(email: String, pass: String) {
        auth = FirebaseAuth.getInstance()
        auth.createUserWithEmailAndPassword(email, pass)
            .addOnCompleteListener(Activity()) { task ->
                if (task.isSuccessful) {
                    val userId = task.result?.user?.uid
                    if (userId != null) {
                        registerFirestore(userId, email)
                    }
                } else {
                    userRegisterFirebase.value = false
                }
            }
    }

    private fun registerFirestore(uid: String, email: String) {
        val usuario = UsuarioFirestore(email)
        firestore = FirebaseFirestore.getInstance()
        firestore.collection("usuarios").document(uid).set(usuario)
            .addOnCompleteListener(Activity()) { task ->
                userRegisterFirebase.value = task.isSuccessful
            }
    }

}