package com.gya.workhome3

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Clients::class], version = 1)
abstract class DataBase : RoomDatabase() {

    abstract fun getDao(): com.gya.workhome3.Dao

    companion object{
        fun getDB(context: Context): DataBase{
            return Room.databaseBuilder(
                context.applicationContext,
                DataBase::class.java,
                "clients.db"
            ).build()
        }
    }
}