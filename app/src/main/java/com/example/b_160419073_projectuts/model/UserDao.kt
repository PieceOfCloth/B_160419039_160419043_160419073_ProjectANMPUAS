package com.example.b_160419073_projectuts.model

import androidx.room.*

@Dao
interface UserDao {
    @Query("SELECT * FROM User WHERE id = :id")
    fun getUser(id:Int): User
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg user:User)
    @Query("UPDATE User SET nama = :name, kelamin = :gender, noHP = :noTlp WHERE id = :id")
    fun editUser(id:Int, name:String, gender:String, noTlp:String)
    @Delete
    fun deleteUser(user:User)
}