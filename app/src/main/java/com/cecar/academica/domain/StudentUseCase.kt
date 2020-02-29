package com.cecar.academica.domain

import com.cecar.academica.data.StudentRepositoryImpl
import com.cecar.academica.presentation.models.Student

class StudentUseCase(private val studentRepository: StudentRepository) {
    fun getStubStudents() = studentRepository.getStubStudents()
}