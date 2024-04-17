package com.example.rayzal_160420103_hobbyapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class News(
    val title: String,
    val description:String,
    val author: String,
    val imageUrl: String,
    val content: List<String>
) : Parcelable