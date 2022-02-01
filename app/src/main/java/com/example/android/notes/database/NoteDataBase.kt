package com.example.android.notes.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.android.notes.database.dao.NoteDao
import com.example.android.notes.model.NoteModel

@Database(entities = [NoteModel::class], version = 1)
abstract class NoteDataBase : RoomDatabase() {
    abstract fun noteDao(): NoteDao

    companion object {
        private var database: NoteDataBase? = null

        @Synchronized
        fun getInstance(context: Context): NoteDataBase {
            return if (database == null) {
                database =
                    Room.databaseBuilder(context, NoteDataBase::class.java, "database").build()
                database as NoteDataBase
            } else database as NoteDataBase
        }
    }
}