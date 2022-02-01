package com.example.android.notes.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.notes.R
import com.example.android.notes.databinding.ItemNoteLayoutBinding
import com.example.android.notes.model.NoteModel
import com.example.android.notes.screens.start.StartFragment

class NoteAdapter : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {
    var listOfNotes = listOf<NoteModel>()

    class NoteViewHolder(note: View) : RecyclerView.ViewHolder(note) {
        val binding = ItemNoteLayoutBinding.bind(note)
        fun bind(note: NoteModel) = with(binding) {
            textTitleCardItem.text = note.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_note_layout, parent, false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(listOfNotes[position])
    }

    override fun getItemCount(): Int {
        return listOfNotes.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<NoteModel>) {
        listOfNotes = list
        notifyDataSetChanged()
    }

    override fun onViewAttachedToWindow(holder: NoteViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener {
            StartFragment.onClickNote(listOfNotes[holder.adapterPosition])
        }
    }

    override fun onViewDetachedFromWindow(holder: NoteViewHolder) {
        holder.itemView.setOnClickListener(null)
    }

}