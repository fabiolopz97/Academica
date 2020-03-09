package com.cecar.academica.presentation.di

import androidx.room.Room
import com.cecar.academica.data.db.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java, "academia"
        ).build()
    }
}