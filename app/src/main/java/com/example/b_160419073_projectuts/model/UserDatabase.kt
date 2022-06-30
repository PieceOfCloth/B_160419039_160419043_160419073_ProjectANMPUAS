package com.example.b_160419073_projectuts.model

import android.content.Context
import androidx.room.*

@Database(entities = arrayOf(User::class), version =  1)
abstract class UserDatabase: RoomDatabase() {
    abstract  fun userDao(): UserDao

    companion object {
        @Volatile private var instance: UserDatabase ?= null
        private val LOCK = Any()

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                UserDatabase::class.java,
                "newuserdb").build()

        operator fun invoke(context:Context) {
            if(instance!=null) {
                synchronized(LOCK) {
                    instance ?: buildDatabase(context).also {
                        instance = it
                    }
                }
            }
        }
    }
}