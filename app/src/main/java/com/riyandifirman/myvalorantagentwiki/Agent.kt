package com.riyandifirman.myvalorantagentwiki

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

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
