package com.afzal.database

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "item_name")
class Subject(
    @NonNull @ColumnInfo(name = "item") val item: String,
    @NonNull @ColumnInfo(name = "price") val price: Int
)