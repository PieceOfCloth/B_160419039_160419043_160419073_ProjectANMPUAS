package com.example.b_160419073_projectuts.model

import androidx.room.*

@Dao
interface KosDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg kos:Kos)
    @Query("SELECT * FROM Kos")
    suspend fun selectAll(): List<Kos>
    @Query("SELECT * FROM Kos WHERE id= :id")
    suspend fun selectKos(id:Int): Kos
    @Delete
    suspend fun deleteKos(kos:Kos)
}