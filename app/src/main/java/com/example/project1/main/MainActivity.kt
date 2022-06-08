package com.example.project1.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.project1.Presenter.IPresenter
import com.example.project1.Presenter.Presenter
import com.example.project1.R
import com.example.project1.adapter.NoteAdapter
import com.example.project1.data.Note
import com.example.project1.fragment.HomeFragment
import com.example.project1.fragment.HomeFragmentDirections
import com.example.project1.sqlite.SqliteHelper
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}