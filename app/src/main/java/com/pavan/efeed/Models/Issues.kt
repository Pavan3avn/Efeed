package com.pavan.efeed.Models

import com.google.gson.annotations.SerializedName

data class Issues(
    @SerializedName("title")
    val title:String,
    @SerializedName("created_at")
    val created:String,
    @SerializedName("closed_at")
    val closed:String,
    @SerializedName("user")
    val user:User

)

data class User(
    @SerializedName("login")
    val name:String,
    @SerializedName("avatar_url")
    val avatarUrl: String

)
