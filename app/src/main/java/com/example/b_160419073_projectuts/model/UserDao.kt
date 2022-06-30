package com.example.b_160419073_projectuts.model

import androidx.room.*

@Dao
interface UserDao {
    @Query("SELECT * FROM User WHERE id = :id")
    suspend fun getUser(id:Int): User
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg user:User)
    @Query("UPDATE User SET nama = :name, kelamin = :gender, noHP = :noTlp WHERE id = :id")
    suspend fun editUser(id:Int, name:String, gender:String, noTlp:String)
    @Delete
    suspend fun deleteUser(user:User)
}