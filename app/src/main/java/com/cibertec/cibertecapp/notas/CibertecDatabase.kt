package com.cibertec.cibertecapp.notas

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Nota::class], version = 1)
abstract class CibertecDatabase: RoomDatabase() {

    abstract fun noteDao(): NotaDao

    companion object {

        private const val DATABASE_NAME = "cibertec_database"

        @Volatile
        private var INSTANCE: CibertecDatabase? = null

        fun getInstance(context: Context): CibertecDatabase? {
            INSTANCE
                ?: synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        CibertecDatabase::class.java,
                        DATABASE_NAME
                    )
                        .build()
                }
            return INSTANCE
        }
    }

}