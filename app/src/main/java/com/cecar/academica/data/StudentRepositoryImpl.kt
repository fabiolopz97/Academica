package com.cecar.academica.data

import com.cecar.academica.data.db.AppDatabase
import com.cecar.academica.data.db.entity.StudentEntity
import com.cecar.academica.data.network.RetrofitClient
import com.cecar.academica.data.network.StudentApi
import com.cecar.academica.domain.StudentRepository
import com.cecar.academica.presentation.models.Student
import io.reactivex.Observable

class StudentRepositoryImpl(val database: AppDatabase) : StudentRepository {
    private val studentApi = RetrofitClient()
        .getRetrofitClient()
        .create(StudentApi::class.java)

    override fun getStubStudents(): Observable<List<Student>> {


        return studentApi.getStudents()
            .map {
                /*
                it.map {
                    val entity = StudentEntity(it.id, it.name)
                    insertStudent(entity)
                    entity
                }
                */
                val results: List<StudentEntity> = it.map {
                    val entity = StudentEntity(it.id, it.name)
                    //insertStudent(entity)
                    entity
                }
                insertStudents(results)
                it
            }
    }

    override fun insertStudent(student: StudentEntity) {
        database.studentDao().insert(student)
    }

    override fun insertStudents(students: List<StudentEntity>) {
        database.studentDao().insertAll(*students.toTypedArray())
    }

    override fun getStudentsForLocalDatabase(): Observable<List<StudentEntity>> {
        return database.studentDao().getStudents()
    }

    /*override fun insertStudents(student: List<StudentEntity>) {
        //database.studentDao().insert(student)
    }*/
}