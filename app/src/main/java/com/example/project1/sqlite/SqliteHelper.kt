package com.example.project1.sqlite

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.fragment.app.FragmentActivity
import com.example.project1.cmmvariable.CmmVariable
import com.example.project1.data.Note

class SqliteHelper(context: FragmentActivity?) :
    SQLiteOpenHelper(context, CmmVariable.DB_Name, null, CmmVariable.DB_Version) {
    override fun onCreate(db: SQLiteDatabase?) {
        val query: String = String.format(
            "create table %s (" +
                    "%s integer primary key autoincrement," +
                    "%s text," +
                    "%s text)",
            Note.Tabble_Name,
            Note.Column_id,
            Note.Column_header,
            Note.Column_text
        )
        db?.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL(String.format("drop table if exists %s", Note.Tabble_Name))
        onCreate(db)
    }

    fun getNote(): ArrayList<Note> {
        val result: ArrayList<Note> = ArrayList()
        val db = this.readableDatabase
        val cursor = db.rawQuery(String.format("select * from %s", Note.Tabble_Name), null)
        if (cursor.moveToFirst()) {
            do {
                val idIndex = cursor.getColumnIndex(Note.Column_id)
                val headerIndex = cursor.getColumnIndex(Note.Column_header)
                val textIndex = cursor.getColumnIndex(Note.Column_text)

                val curItem = Note(
                    cursor.getInt(idIndex),
                    cursor.getString(headerIndex),
                    cursor.getString(textIndex)
                )
                result.add(curItem)
            } while (cursor.moveToNext())
        }
        return result
    }

    fun insertNote(note: Note): Long {
        val cv = ContentValues()
        cv.put(Note.Column_header, note.header)
        cv.put(Note.Column_text, note.text)
        val db = this.writableDatabase
        val result = db.insert(Note.Tabble_Name, null, cv)
        db.close()
        return result
    }

    fun updateNote(note: Note): Int {
        val cv = ContentValues()
        cv.put(Note.Column_header, note.header)
        cv.put(Note.Column_text, note.text)
        val db = this.writableDatabase
        val whereClause: String = String.format("%s = %s", Note.Column_id, note.id)
        val result = db.update(Note.Tabble_Name, cv, whereClause, null)
        db.close()
        return result
    }

    fun deleteNote(id: Int): Int {
        val db = this.writableDatabase
        val whereClause = String.format("%s =%s", Note.Column_id, id)
        val result = db.delete(Note.Tabble_Name, whereClause, null)
        db.close()
        return result
    }

}