package com.cecar.academica.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cecar.academica.R
import com.cecar.academica.presentation.models.Student
import kotlinx.android.synthetic.main.item_student_layout.view.*

class StudentAdapter(private val data: List<Student>): RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_student_layout, parent, false)
        return StudentViewHolder(view)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val item = data[position]
        holder.itemView.tvName.text = item.name

    }

    inner class StudentViewHolder(view: View): RecyclerView.ViewHolder(view)
}
