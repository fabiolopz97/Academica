package com.cecar.academica.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.cecar.academica.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Referencia al viewmodel StudentViewModel
        val studentViewModel = ViewModelProvider(this).get(StudentViewModel::class.java)
        //codigo anterior
        //val students = studentViewModel.getStudents()
        //val studentAdapter = StudentAdapter(it)

        studentViewModel.mLiveData.observe(this, Observer {
            val studentAdapter = StudentAdapter(it)
            rvStudents.apply {
                adapter = studentAdapter
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(this@MainActivity)
            }
        })

        studentViewModel.getStudentsWithLiveData()
    }

}
