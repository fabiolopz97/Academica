package com.cecar.academica.data

import com.cecar.academica.data.network.RetrofitClient
import com.cecar.academica.data.network.StudentApi
import com.cecar.academica.domain.StudentRepository
import com.cecar.academica.presentation.models.Student
import io.reactivex.Observable

class StudentRepositoryImpl: StudentRepository {
    private val studentApi = RetrofitClient()
        .getRetrofitClient()
        .create(StudentApi::class.java)

    override fun getStubStudents(): Observable<List<Student>>{
        return studentApi.getStudents()
    }
}