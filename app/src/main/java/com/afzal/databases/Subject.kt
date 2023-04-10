package com.afzal.databases

import androidx.annotation.NonNull
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.NumberFormat
import java.util.*
import kotlin.collections.ArrayList

@Entity(tableName = "item_name")
class Subject(@NonNull @ColumnInfo(name = "item") val item: String,
              @NonNull @ColumnInfo(name = "price") val price: Float
){
    @PrimaryKey(autoGenerate = true) var id = 0
    fun getFormattedPrice(): String = formatter.format(price)
    companion object{
        val formatter:NumberFormat = NumberFormat.getCurrencyInstance()
        init {
            formatter.currency = Currency.getInstance("INR")
        }
    }
}

