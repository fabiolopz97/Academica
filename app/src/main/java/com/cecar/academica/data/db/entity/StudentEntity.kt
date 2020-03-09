package com.cecar.academica.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student")
data class StudentEntity (
    @PrimaryKey val uid: Int,
    val name: String
)
