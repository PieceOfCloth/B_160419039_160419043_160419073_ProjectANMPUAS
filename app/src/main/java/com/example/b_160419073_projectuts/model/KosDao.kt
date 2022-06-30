package com.example.b_160419073_projectuts.model

import androidx.room.*

@Dao
interface KosDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg kos:Kos)
    @Query("SELECT * FROM Kos")
    fun selectAllKos(): List<Kos>
    @Query("SELECT * FROM Kos WHERE id = :id")
    fun selectKos(id:Int): Kos
    @Delete
    fun deleteKos(kos:Kos)
}

