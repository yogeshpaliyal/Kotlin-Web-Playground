package com.example.model

import com.google.gson.annotations.SerializedName

data class LibraryModel(
    @SerializedName("name")
    val name : String,
    @SerializedName("github")
    val github : String,
    @SerializedName("proguard")
    val proguard : String,
)
