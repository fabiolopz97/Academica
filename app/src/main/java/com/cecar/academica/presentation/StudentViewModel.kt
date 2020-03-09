package com.cecar.academica.presentation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cecar.academica.data.StudentRepositoryImpl
import com.cecar.academica.domain.StudentRepository
import com.cecar.academica.domain.StudentUseCase
import com.cecar.academica.presentation.models.Student
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class StudentViewModel: ViewModel() {

    private val studentUseCase = StudentUseCase()
    var mLiveData = MutableLiveData<List<Student>>()

    fun getStudents() = studentUseCase.getStubStudents()

    /*fun getStudentsWithLiveData(){
        mLiveData.value = studentUseCase.getStubStudents()
    }*/
    fun getStudentsWithLiveData(){
        studentUseCase.getStubStudents()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mLiveData.value = it
            },{
                Log.i("error", "mensajeError $it")
            })
    }

    fun getStudentsForLocalDatabase(){
        studentUseCase.getStudentsForDatabase()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                //mLiveData.value = it
                val data = it
            },{
                Log.i("error", "mensajeError $it")
            })
    }
}