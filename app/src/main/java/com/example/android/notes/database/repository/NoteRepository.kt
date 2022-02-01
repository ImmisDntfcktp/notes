package com.example.android.notes.database.repository

import androidx.lifecycle.LiveData
import com.example.android.notes.model.NoteModel
import io.reactivex.rxjava3.internal.operators.single.SingleDoOnSuccess

interface NoteRepository {
    val listOfAllNotes: LiveData<List<NoteModel>>
    suspend fun insertNote(note: NoteModel, onSuccess: () -> Unit)
    suspend fun deleteNote(note: NoteModel, onSuccess: () -> Unit)
    suspend fun updateNote(note: NoteModel, onSuccess: () -> Unit)
}