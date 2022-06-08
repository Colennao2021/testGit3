package com.example.project1.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Note(
    val id: Int = 0,
    val header: String,
    val text: String
) :Parcelable {
    companion object {
        const val Tabble_Name: String = "tb_note"
        const val Column_id: String = "id"
        const val Column_header: String = "header"
        const val Column_text: String = "text"
    }
}