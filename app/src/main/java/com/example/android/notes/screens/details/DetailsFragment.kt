package com.example.android.notes.screens.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.android.notes.APP
import com.example.android.notes.R
import com.example.android.notes.databinding.FragmentDetailsBinding
import com.example.android.notes.model.NoteModel
import com.example.android.notes.screens.addnote.AddNoteViewModel

class DetailsFragment : Fragment() {

    lateinit var binding: FragmentDetailsBinding
    lateinit var currentNote: NoteModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailsBinding.inflate(inflater)
        currentNote = arguments?.getSerializable("note") as NoteModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this)[DetailsViewModel::class.java]
        val id = currentNote.id
        val title = currentNote.title
        val description = currentNote.description
        binding.textTitleDetails.setText(title)
        binding.textDescriptionDetails.setText(description)

        binding.buttonBackToList.setOnClickListener {
            APP.navController.navigate(R.id.action_detailsFragment_to_startFragment)
        }
        binding.buttonUpdate.setOnClickListener {
            val updateTitle = binding.textTitleDetails.text.toString()
            val updateDescription = binding.textDescriptionDetails.text.toString()
            viewModel.editNote(NoteModel(id, updateTitle,updateDescription)){}
            APP.navController.navigate(R.id.action_detailsFragment_to_startFragment)
        }
        binding.buttonDeleteNote.setOnClickListener {
            viewModel.deleteNote(currentNote){}
            APP.navController.navigate(R.id.action_detailsFragment_to_startFragment)
        }
    }
}