package com.example.project1.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.project1.Presenter.IPresenter
import com.example.project1.Presenter.Presenter
import com.example.project1.R
import com.example.project1.adapter.NoteAdapter
import com.example.project1.data.Note
import com.example.project1.main.MainActivity
import com.example.project1.sqlite.SqliteHelper
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HomeFragment : Fragment(),IPresenter{

    lateinit var recyclewView :RecyclerView
    lateinit var addFloatButton :FloatingActionButton
    lateinit var sqliteHelper :SqliteHelper
    lateinit var presenter :Presenter
    lateinit var listData :ArrayList<Note>
    lateinit var adapter :NoteAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        recyclewView=view.findViewById(R.id.recycleView_home)
        addFloatButton=view.findViewById(R.id.float_add)
        sqliteHelper= SqliteHelper(activity)
        listData= ArrayList()
        presenter= Presenter(this,listData)
        adapter= NoteAdapter()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        event()
        addNote()
    }

    private fun addNote() {
        addFloatButton.setOnClickListener {
            val action =HomeFragmentDirections.actionHomeFragmentToPostFragment()
            findNavController().navigate(action)
        }
    }

    private fun event() {
        presenter.getAllNote()
        adapter.setListData(listData)
        recyclewView.adapter=adapter
        recyclewView.layoutManager=LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false)
    }

    override fun getAllNote(): ArrayList<Note> {
        return sqliteHelper.getNote()
    }

    override fun insertNote(note: Note) {

    }

    override fun deleteNote(id: Int) {
        TODO("Not yet implemented")
    }

    override fun updateNote(note: Note) {
        TODO("Not yet implemented")
    }
}