package com.gya.workhome3

import android.database.Cursor
import androidx.room.Insert
import androidx.room.Query

@androidx.room.Dao
interface Dao {
    @Insert
    fun insertClients(clients: Clients)

    @Query("Select * from Clients")
    fun getAllClients(): Cursor
}