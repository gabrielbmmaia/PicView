package com.example.photo_list_data.remote.dtos

import com.google.gson.annotations.SerializedName

data class UserDto(
    @SerializedName("links")
    val userLinks: UserLinksDto,
    val username: String
)
