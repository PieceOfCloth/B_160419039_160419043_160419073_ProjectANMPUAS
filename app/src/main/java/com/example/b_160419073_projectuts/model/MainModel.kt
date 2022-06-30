package com.example.b_160419073_projectuts.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Kos(
    @ColumnInfo(name="photoUrl")
    @SerializedName("photo_url")
    var photoUrl:String?,
    @ColumnInfo(name="nama_kos")
    var nama_kos:String?,
    @ColumnInfo(name="deskripsi")
    var deskripsi:String?,
    @ColumnInfo(name="phone_number")
    var phone_number:String?,
    @ColumnInfo(name="alamat")
    var alamat:String?,
    @ColumnInfo(name="range_Harga")
    var range_harga:String?
){
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0
}

@Entity
data class User(
    @ColumnInfo(name="photoUrl")
    var photoUrl: String?,
    @ColumnInfo(name="nama")
    var nama: String?,
    @ColumnInfo(name="gender")
    var gender: String?,
    @ColumnInfo(name="noHP")
    var noHP: String?
){
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0
}

@Entity
data class Artikel(
    @ColumnInfo(name="title")
    var title: String?,
    @ColumnInfo(name="deskripsi")
    var deskripsi: String?,
    @ColumnInfo(name="photoUrl")
    var photoUrl: String?
){
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0
}