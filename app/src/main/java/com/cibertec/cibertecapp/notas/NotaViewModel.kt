package com.cibertec.cibertecapp.notas

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class NotaViewModel (application: Application): AndroidViewModel(application) {

    private val repository = NotaRepository(application)

    val notes = repository.getNotes()

    fun saveNotes(nota: Nota) {
        viewModelScope.launch {
            repository.insertNoteWithCoroutines(nota)
        }
    }

}