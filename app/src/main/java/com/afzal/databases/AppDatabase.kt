package com.afzal.databases

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Subject::class], version = 2,exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun subjectDao(): SubjectDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database")
//                    .createFromAsset("database/item_name.db"
                    .build()
                INSTANCE = instance

                instance
            }
        }
    }
}
