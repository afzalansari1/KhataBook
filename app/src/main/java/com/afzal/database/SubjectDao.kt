package com.afzal.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface SubjectDao{
    @Insert
    suspend fun insert(item: Subject)

    @Delete
    suspend fun delete(item: Subject)

    @Query("SELECT * FROM item_name ORDER BY id ASC")
    fun getAllSubject(): LiveData<List<Subject>>

}