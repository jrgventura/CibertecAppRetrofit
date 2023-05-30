package com.cibertec.cibertecapp.notas

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NotaDao {

    @Insert
    fun insert(note: Nota)

    @Update
    fun update(note: Nota)

    @Delete
    fun delete(note: Nota)

    @Query("SELECT * FROM note_table")
    fun getNote(): LiveData<List<Nota>>

}