package com.example.b_160419073_projectuts.model

import androidx.room.*

interface ArticleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg article:Artikel)
    @Query("SELECT * FROM Artikel")
    suspend fun selectAll(): List<Artikel>
    @Query("SELECT * FROM Artikel WHERE id= :id")
    suspend fun selectArtikel(id:Int): Artikel
    @Delete
    suspend fun deleteArtikel(kos:Artikel)
}