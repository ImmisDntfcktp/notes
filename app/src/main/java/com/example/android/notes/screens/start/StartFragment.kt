package com.example.android.notes.screens.start

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.android.notes.APP
import com.example.android.notes.MainActivity
import com.example.android.notes.R
import com.example.android.notes.adapter.NoteAdapter
import com.example.android.notes.databinding.FragmentStartBinding
import com.example.android.notes.model.NoteModel

class StartFragment : Fragment() {

    lateinit var binding: FragmentStartBinding
    lateinit var recyclerView: RecyclerView
    lateinit var noteAdapter: NoteAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStartBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this)[StartViewModel::class.java]
        viewModel.initDataBase()
        recyclerView = binding.recyclerViewNotes
        noteAdapter = NoteAdapter()
        recyclerView.adapter = noteAdapter
        viewModel.getAllNotes().observe(viewLifecycleOwner, { listOfNotes ->
            val listOfNotesRevers = listOfNotes.asReversed()
            noteAdapter.setList(listOfNotesRevers)
        })
        binding.buttonAdd.setOnClickListener{
            APP.navController.navigate(R.id.action_startFragment_to_addNoteFragment)
        }
    }

    companion object{
        fun onClickNote(note:NoteModel){
            val bundle = Bundle()
            bundle.putSerializable("note", note)
            APP.navController.navigate(R.id.action_startFragment_to_detailsFragment, bundle )
        }
    }
}