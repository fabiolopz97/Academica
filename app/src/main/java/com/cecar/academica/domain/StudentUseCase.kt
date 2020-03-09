package com.cecar.academica.domain

import com.cecar.academica.data.db.entity.StudentEntity
import com.cecar.academica.presentation.models.Student
import io.reactivex.Observable
import org.koin.core.KoinComponent
import org.koin.core.inject

class StudentUseCase: KoinComponent {
    private val repository: StudentRepository by inject()
    fun getStubStudents():Observable<List<Student>> {
        return repository.getStubStudents()
    }
    fun getStudentsForDatabase():Observable<List<StudentEntity>> {
        return repository.getStudentsForLocalDatabase()
    }
}