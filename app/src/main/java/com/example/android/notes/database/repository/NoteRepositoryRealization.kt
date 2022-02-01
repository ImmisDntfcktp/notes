package com.example.android.notes.database.repository

import androidx.lifecycle.LiveData
import com.example.android.notes.database.dao.NoteDao
import com.example.android.notes.model.NoteModel

class NoteRepositoryRealization(private val noteDao: NoteDao):NoteRepository {
    override val listOfAllNotes: LiveData<List<NoteModel>>
        get() = noteDao.getAllNotes()

    override suspend fun insertNote(note: NoteModel, onSuccess: () -> Unit) {
        noteDao.insert(note)
        onSuccess()
    }

    override suspend fun deleteNote(note: NoteModel, onSuccess: () -> Unit) {
        noteDao.delete(note)
        onSuccess()
    }

    override suspend fun updateNote(note: NoteModel, onSuccess: () -> Unit) {
        noteDao.update(note)
        onSuccess()
    }

}