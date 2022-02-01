package com.example.android.notes.screens.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.notes.REPOSITORY
import com.example.android.notes.model.NoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailsViewModel : ViewModel() {
    fun editNote(note: NoteModel, onSuccess: () -> Unit) =
        viewModelScope.launch(Dispatchers.IO){
            REPOSITORY.updateNote(note){
                onSuccess()
            }
        }
    fun deleteNote(note: NoteModel, onSuccess: () -> Unit) =
        viewModelScope.launch(Dispatchers.IO){
            REPOSITORY.deleteNote(note){
                onSuccess()
            }
        }
}