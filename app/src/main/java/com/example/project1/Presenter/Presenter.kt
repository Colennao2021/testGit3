package com.example.project1.Presenter

import com.example.project1.data.Note

class Presenter {

    private var listData :ArrayList<Note> = ArrayList()
    private var iPresenter: IPresenter

    constructor(iPresenter: IPresenter,listData :ArrayList<Note>){
        this.iPresenter=iPresenter
        this.listData=listData
    }

    public fun getAllNote(){
        listData=iPresenter.getAllNote()
    }

    public fun insertNote(note: Note) {

    }

    public fun updateNote(note: Note) {
        return iPresenter.updateNote(note)
    }

    public fun deleteNote(id: Int) {
        return iPresenter.deleteNote(id)
    }

}