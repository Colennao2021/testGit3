package com.example.project1.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.project1.R
import com.example.project1.data.Note
import kotlinx.android.synthetic.main.item_layout.view.*

class NoteAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var listData: ArrayList<Note> = ArrayList()

    public fun setListData(listData: ArrayList<Note>) {
        this.listData = listData
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder) {
            holder.bindingData(listData[position])
        }
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    class ViewHolder constructor(item: View) : RecyclerView.ViewHolder(item) {
        private val txtId = item.txt_id_item
        private val txtHeader = item.txt_header

        fun bindingData(note: Note) {
            txtId.text = note.id.toString()
            txtHeader.text = note.header
        }
    }
}