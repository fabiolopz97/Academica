package com.cecar.academica.domain

import com.cecar.academica.data.db.entity.StudentEntity
import com.cecar.academica.presentation.models.Student
import io.reactivex.Observable

interface StudentRepository {
    fun getStubStudents(): Observable<List<Student>>
    fun insertStudent(student: StudentEntity)
    fun insertStudents(students: List<StudentEntity>)
    fun getStudentsForLocalDatabase(): Observable<List<StudentEntity>>
}