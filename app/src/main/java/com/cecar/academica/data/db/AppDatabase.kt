package com.cecar.academica.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cecar.academica.data.db.dao.StudentDao
import com.cecar.academica.data.db.entity.StudentEntity

@Database(entities = [StudentEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase(){
    abstract fun studentDao(): StudentDao
}