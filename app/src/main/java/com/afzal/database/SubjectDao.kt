package com.afzal.database

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface SubjectDao{
    @Query("SELECT * FROM subject ORDER BY item_name ASC")
    fun getAll(): Flow<List<Subject>>

    @Query("SELECT * FROM subject WHERE item_name = :itemName ORDER BY item_name ASC")
    fun getByItemName(itemName : String): Flow<List<Subject>>

}