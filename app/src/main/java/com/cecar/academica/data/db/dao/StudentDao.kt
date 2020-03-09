package com.cecar.academica.data.db.dao

import androidx.room.*
import com.cecar.academica.data.db.entity.StudentEntity
import io.reactivex.Observable
import io.reactivex.Observer

@Dao
interface StudentDao {
    @Query("select * from student")
    fun getStudents(): Observable<List<StudentEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg student: StudentEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(student: StudentEntity)

    @Delete
    fun delete(student: StudentEntity)

    @Update
    fun update(student: StudentEntity)

}