package com.gya.workhome3

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Clients")
data class Clients(
    @PrimaryKey(autoGenerate = true)
    var idClients: Long?,
    @ColumnInfo(name = "familiya")
    var fio_clients: String,
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "second_name")
    var second_name: String,
    @ColumnInfo(name = "years")
    var years: Int,
    @ColumnInfo(name = "home")
    var home: String
)