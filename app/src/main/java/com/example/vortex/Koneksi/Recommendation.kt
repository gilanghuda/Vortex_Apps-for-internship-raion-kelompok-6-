package com.example.vortex.Koneksi

import androidx.annotation.DrawableRes
import com.example.vortex.R

data class Recommendation(
    val name: String,
    val description: String,
    val location: String,
    val role: String,
    val sector: String,
    @DrawableRes val image: Int
)

val recommendations = listOf(
    Recommendation(
        "Vira Affifah",
        "Fabrics, bisnis tekstil yang menawarkan berbagai macam...",
        "Malang, Jawa Timur",
        "Pengusaha",
        "Kuliner",
        R.drawable.owi),
    Recommendation(
        "Pradip Irwansyah",
        "Bistro Dimsum merupakah sebuah usaha kuliner dengan...",
        "Malang, Jawa Timur",
        "Pengusaha",
        "Tambang",
        R.drawable.megachan),
    Recommendation(
        "Vira Affifah",
        "Fabrics, bisnis tekstil yang menawarkan berbagai macam...",
        "Malang, Jawa Timur",
        "Pengusaha",
        "Kuliner",
        R.drawable.owi),
    Recommendation(
        "Pradip Irwansyah",
        "Bistro Dimsum merupakah sebuah usaha kuliner dengan...",
        "Malang, Jawa Timur",
        "Pengusaha",
        "Tambang",
        R.drawable.megachan),
    Recommendation(
        "Vira Affifah",
        "Fabrics, bisnis tekstil yang menawarkan berbagai macam...",
        "Malang, Jawa Timur",
        "Pengusaha",
        "Kuliner",
        R.drawable.megachan),
    Recommendation(
        "Pradip Irwansyah",
        "Bistro Dimsum merupakah sebuah usaha kuliner dengan...",
        "Malang, Jawa Timur",
        "Pengusaha",
        "Tambang",
        R.drawable.owi)
)

