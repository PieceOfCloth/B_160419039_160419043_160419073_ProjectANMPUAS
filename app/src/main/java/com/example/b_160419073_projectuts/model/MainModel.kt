package com.example.b_160419073_projectuts.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Kos(
    @SerializedName("photo_url")
    @ColumnInfo(name="photourl")
    var photoUrl:String,
    @ColumnInfo(name="nama_kos")
    var nama_kos:String,
    @ColumnInfo(name="deskripsi")
    var deskripsi:String,
    @ColumnInfo(name="phone_number")
    var phone_number:String,
    @ColumnInfo(name="alamat")
    var alamat:String,
    @ColumnInfo(name="range_harga")
    var range_harga:String
){
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0
}

