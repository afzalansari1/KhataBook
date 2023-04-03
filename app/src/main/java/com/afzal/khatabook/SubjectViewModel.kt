package com.afzal.khatabook

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.afzal.database.AppDatabase
import com.afzal.database.Subject
import com.afzal.database.SubjectRepository

class SubjectViewModel(application: Application) : AndroidViewModel(application) {

    val allSubject: LiveData<List<Subject>>

    init {
        val dao = AppDatabase.getDatabase(application).subjectDao()
        val repository = SubjectRepository(dao)
        allSubject = repository.allSubjects
    }

}