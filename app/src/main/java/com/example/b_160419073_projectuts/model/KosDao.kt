package com.example.b_160419073_projectuts.model

import androidx.room.*

@Dao
interface KosDao {
    @Query("SELECT * FROM Kos")
    suspend fun selectAllKos():List<Kos>
    @Query("SELECT * FROM Kos WHERE id = :id")
    suspend fun selectKos(id:Int):Kos
    @Query("SELECT * FROM Kos WHERE nama_kos LIKE :key")
    suspend fun searchKos(key:String):List<Kos>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg kos:Kos)
    @Delete
    suspend fun deleteKos(kos:Kos)
}