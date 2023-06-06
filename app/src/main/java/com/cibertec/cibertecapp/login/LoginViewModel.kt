package com.cibertec.cibertecapp.login

import android.app.Activity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cibertec.cibertecapp.network.LoginResponse
import com.google.firebase.auth.FirebaseAuth
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class LoginViewModel: ViewModel() {

    private lateinit var auth: FirebaseAuth
    private val repository = LoginRepository()
    private val disposable = CompositeDisposable()

    val userLoginServiceResponse = MutableLiveData<Boolean>()

    fun login(email: String, pass: String) {
        // loginRetrofit(email, pass)
        loginFirebase(email, pass)
    }

    private fun loginRetrofit(email:String, pass: String) {
        disposable.add(
            repository.login(email, pass)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<LoginResponse>() {
                    override fun onSuccess(t: LoginResponse) {
                        userLoginServiceResponse.value = true
                    }

                    override fun onError(e: Throwable) {
                        userLoginServiceResponse.value = false
                    }
                })
        )
    }

    public fun loginFirebase(email: String, pass: String) {
        auth = FirebaseAuth.getInstance()
        auth.signInWithEmailAndPassword(email, pass)
            .addOnCompleteListener(Activity()) { task ->
                if (task.isSuccessful) {
                    val userId = task.result?.user?.uid
                    // Login correcto
                    userLoginServiceResponse.value = true
                } else {
                    // Login incorrecto
                    userLoginServiceResponse.value = false
                }
            }
    }

}