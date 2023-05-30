package com.cibertec.cibertecapp.notas

import android.app.Application
import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NotaRepository(application: Application) {

    private val noteDao: NotaDao? = CibertecDatabase.getInstance(application)?.noteDao()

    suspend fun insertNoteWithCoroutines(nota: Nota) {
        processInsertNote(nota)
    }

    private suspend fun processInsertNote(nota: Nota) {
        withContext(Dispatchers.Default) {
            noteDao?.insert(nota)
        }
    }

    fun getNotes(): LiveData<List<Nota>>? {
        return noteDao?.getNote()
    }



}