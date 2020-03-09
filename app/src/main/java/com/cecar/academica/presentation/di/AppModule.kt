package com.cecar.academica.presentation.di

import com.cecar.academica.data.StudentRepositoryImpl
import com.cecar.academica.domain.StudentRepository
import org.koin.dsl.module

val appModule = module {
    factory <StudentRepository>{ StudentRepositoryImpl(database =  get()) }
}