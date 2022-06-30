package com.example.b_160419073_projectuts.model

import androidx.room.*

interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg user:User)
    @Query("SELECT * FROM User")
    suspend fun selectAll(): List<User>
    @Query("SELECT * FROM User WHERE id= :id")
    suspend fun selectuser(id:Int): User
    @Delete
    suspend fun deleteuser(user:User)
}