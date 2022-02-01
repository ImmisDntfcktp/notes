package com.example.android.notes.screens.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.android.notes.REPOSITORY
import com.example.android.notes.database.NoteDataBase
import com.example.android.notes.database.repository.NoteRepositoryRealization
import com.example.android.notes.model.NoteModel

class StartViewModel(application: Application) : AndroidViewModel(application) {
    val context = application

    fun initDataBase() {
        val daoNote = NoteDataBase.getInstance(context).noteDao()
        REPOSITORY = NoteRepositoryRealization(daoNote)
    }

    fun getAllNotes(): LiveData<List<NoteModel>> {
        return REPOSITORY.listOfAllNotes
    }

    fun checkNotes(query: String?): List<NoteModel> {
        val listOfNotes = REPOSITORY.listOfAllNotes
        val listQuery = arrayListOf<NoteModel>()
        listOfNotes.value?.forEach {
            if (it.title.contains(query.toString()) || it.description.contains(query.toString())) {
                listQuery.add(it)
            }
        }
        return listQuery
    }
}