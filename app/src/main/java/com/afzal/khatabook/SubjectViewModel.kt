package com.afzal.khatabook

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.afzal.databases.AppDatabase
import com.afzal.databases.Subject
import com.afzal.databases.SubjectRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SubjectViewModel(application: Application) : AndroidViewModel(application) {
    private val repository : SubjectRepository
    val allSubject: LiveData<List<Subject>>

    init {
        val dao = AppDatabase.getDatabase(application).subjectDao()
        repository = SubjectRepository(dao)
        allSubject = repository.allSubjects
    }

    fun deleteNode(subject: Subject) = viewModelScope.launch(Dispatchers.IO){
        repository.delete(subject)
    }

    fun insertNode(subject: Subject) = viewModelScope.launch(Dispatchers.IO){
        repository.insert(subject)
    }

}