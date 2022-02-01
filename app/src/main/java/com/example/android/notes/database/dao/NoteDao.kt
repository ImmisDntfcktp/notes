package com.example.android.notes.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.android.notes.model.NoteModel

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: NoteModel)

    @Delete
    suspend fun delete(note: NoteModel)

    @Update
    suspend fun update(note: NoteModel)

    @Query("SELECT * FROM NOTE_TABLE")
    fun getAllNotes():LiveData<List<NoteModel>>
}