package com.example.b_160419073_projectuts.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.b_160419073_projectuts.util.MIGRATIONS_1_2

@Database(entities = arrayOf(Kos::class, User::class), version = 2)
abstract class KosDatabase:RoomDatabase() {
    abstract fun kosDao(): KosDao
    abstract fun userDao(): UserDao

    companion object{
        @Volatile private var instance: KosDatabase ?= null
        private val LOCK = Any()

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                KosDatabase::class.java,
                "newkosdb")
                .addMigrations(MIGRATIONS_1_2)
                .build()

        operator fun invoke(context:Context){
            if(instance != null){
                synchronized(LOCK){
                    instance ?: buildDatabase(context).also{
                        instance = it
                    }
                }
            }
        }
    }
}