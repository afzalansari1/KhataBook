package com.afzal.databases

import androidx.lifecycle.LiveData

class SubjectRepository(private val subjectDao : SubjectDao) {
    val allSubjects: LiveData<List<Subject>> = subjectDao.getAllSubject()

    suspend fun insert(subject : Subject){
        subjectDao.insert(subject)
    }

    suspend fun delete(subject: Subject){
        subjectDao.delete(subject)
    }

}