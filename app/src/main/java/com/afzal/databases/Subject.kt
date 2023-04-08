package com.afzal.databases

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.function.IntToLongFunction

@Entity(tableName = "item_name")
class Subject(@NonNull @ColumnInfo(name = "item") val item: String,
              @NonNull @ColumnInfo(name = "price") val price: Float
){
    @PrimaryKey(autoGenerate = true) var id = 0
}