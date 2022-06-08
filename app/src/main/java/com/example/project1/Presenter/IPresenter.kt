package com.example.project1.Presenter

import com.example.project1.data.Note

interface IPresenter {

    fun getAllNote() :ArrayList<Note>
    fun insertNote(note: Note)
    fun deleteNote(id: Int)
    fun updateNote(note: Note)
}