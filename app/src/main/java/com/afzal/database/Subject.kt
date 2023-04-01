package com.afzal.database

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Subject(
    @PrimaryKey val id : Int,
    @NonNull @ColumnInfo(name = "item_name") val itemName: String,
    @NonNull @ColumnInfo(name = "item_price") val itemPrice: Int
)
