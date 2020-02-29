package com.cecar.academica.data.network

import com.cecar.academica.presentation.models.Student
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET

interface StudentApi {
    @GET("v2/5e5a91b03000003e031f0ba0")
    fun getStudents(): Observable<List<Student>>
}