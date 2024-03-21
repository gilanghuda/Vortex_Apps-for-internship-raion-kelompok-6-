package com.example.vortex.Start

data class User(
    val noTelp: String,
    val name: String,
    val email: String,
    val role: String,
    val description: String,
    val location: String,
    val bidang: String,
    val profilePictureUrl: String? = null // Optional, can be null
)