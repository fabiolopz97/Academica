package com.cecar.academica.domain

import com.cecar.academica.presentation.models.Student
import io.reactivex.Observable

interface StudentRepository {
    fun getStubStudents(): Observable<List<Student>>
}