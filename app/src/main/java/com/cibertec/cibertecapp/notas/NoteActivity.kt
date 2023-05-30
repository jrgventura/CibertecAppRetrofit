package com.cibertec.cibertecapp.notas

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cibertec.cibertecapp.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class NoteActivity: AppCompatActivity(), NoteAdapter.ItemClickListener {

    private lateinit var notaViewModel: NotaViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nota)

        notaViewModel = run {
            ViewModelProvider(this)[NotaViewModel::class.java]
        }

        val recyclerNota = findViewById<RecyclerView>(R.id.recyclerNotas)

        val adapter = NoteAdapter(this)
        recyclerNota.adapter = adapter
        recyclerNota.layoutManager = LinearLayoutManager(this)

        notaViewModel.notes?.observe(this){ notas ->
            notas?.let {
                adapter.setNotes(notas)
            }
        }

        val floatingRegister = findViewById<FloatingActionButton>(R.id.floatingRegister)
        floatingRegister.setOnClickListener {
            registerAndUpdateNote()
        }

    }

    private fun registerAndUpdateNote() {
        val mDialogView = LayoutInflater.from(this).inflate(R.layout.dialog_note, null)

        val titleAlertNote = "Registrar nota"

        val mBuilder = AlertDialog.Builder(this)
            .setView(mDialogView)
            .setTitle(titleAlertNote)

        val mAlertDialog = mBuilder.show()

        val buttonCreate  = mDialogView.findViewById<Button>(R.id.btnCreate)
        val editTextTitleCreate  = mDialogView.findViewById<EditText>(R.id.edtTitleNote)
        val editTextDescriptionCreate  = mDialogView.findViewById<EditText>(R.id.edtDescriptionNote)

        buttonCreate.setOnClickListener {

            mAlertDialog.dismiss()

            val titleNote = editTextTitleCreate.text.toString()
            val descriptionNote = editTextDescriptionCreate.text.toString()
            val currentDateTime = LocalDateTime.now().formatChangeNote()

            var noteVM = Nota(titleNote, descriptionNote, currentDateTime)
            notaViewModel.saveNotes(noteVM)

        }
    }

    fun LocalDateTime.formatChangeNote() : String
            = this.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))

    override fun onItemClick(noteItem: Nota) {

    }


}