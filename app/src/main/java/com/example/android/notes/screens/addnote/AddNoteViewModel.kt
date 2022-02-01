package com.example.android.notes.screens.addnote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.notes.REPOSITORY
import com.example.android.notes.model.NoteModel
import io.reactivex.rxjava3.internal.operators.single.SingleDoOnSuccess
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddNoteViewModel : ViewModel() {
    fun insertNote(note: NoteModel, onSuccess: () -> Unit) =
        viewModelScope.launch(Dispatchers.IO){
            REPOSITORY.insertNote(note){
                onSuccess()
            }
        }
}