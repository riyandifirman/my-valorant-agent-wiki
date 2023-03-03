package com.riyandifirman.myvalorantagentwiki

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

// Membuat data class untuk menyimpan data agent
// Parcelable digunakan untuk mengirim data antar activity
@Parcelize
data class Agent(
    val name : String,
    val role : String,
    val country : String,
    val ultimate : String,
    val role_icon : Int,
    val description : String,
    val photo : Int
) : Parcelable
