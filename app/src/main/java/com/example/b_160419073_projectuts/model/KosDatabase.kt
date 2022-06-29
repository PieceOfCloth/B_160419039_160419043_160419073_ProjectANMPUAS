package com.example.b_160419073_projectuts.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Kos::class), version = 1)
abstract class KosDatabase: RoomDatabase(){
    abstract fun kosDao():KosDao

    companion object {
        @Volatile private var instance:KosDatabase ?= null
        private val LOCK = Any()

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            KosDatabase::class.java,
            "kosdb"
        ).build()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also{
                instance = it
            }
        }
    }
}