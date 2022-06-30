package com.example.b_160419073_projectuts.model

import com.google.gson.annotations.SerializedName

data class Kos(
    val id:String?,
    @SerializedName("photo_url")
    val photoUrl:String?,
    val nama_kos:String?,
    val deskripsi:String?,
    val phone_number:String?,
    val alamat:String?,
    val range_harga:String?
)

data class User(
    val photoUrl: String?,
    val nama: String?,
    val gender: String?,
    val noHP: String?
)