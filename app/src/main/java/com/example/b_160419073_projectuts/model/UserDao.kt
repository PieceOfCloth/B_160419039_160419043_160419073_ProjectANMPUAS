package com.example.b_160419073_projectuts.model

import androidx.room.*

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg user: User)

    @Query("SELECT * FROM user")
    suspend fun selectAllTodo(): List<User>

    @Query("SELECT * FROM user WHERE id = :id")
    suspend fun selectTodo(id:Int): User

    @Delete
    suspend fun deleteTodo(user: User)
}