package com.example.b_160419073_projectuts.util

import android.content.Context
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.b_160419073_projectuts.model.KosDatabase

val DB_NAME = "newkosdb"

fun buildDB(context:Context):KosDatabase{
    val db = Room.databaseBuilder(context,
        KosDatabase::class.java, DB_NAME)
        .addMigrations(MIGRATIONS_1_2)
        .build()
    return db
}

val MIGRATIONS_1_2 = object: Migration(1,2){
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("CREATE TABLE User (id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, nama TEXT, kelamin TEXT, noHP TEXT)")
    }

}