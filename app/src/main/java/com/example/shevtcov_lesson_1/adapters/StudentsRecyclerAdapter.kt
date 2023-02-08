package com.example.shevtcov_lesson_1.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.shevtcov_lesson_1.databinding.ItemStudentBinding
import com.example.shevtcov_lesson_1.models.Student

class StudentsRecyclerAdapter: ListAdapter<Student, StudentsRecyclerAdapter.StudentViewHolder>(DiffCallback()) {

    class StudentViewHolder(
        private val binding: ItemStudentBinding,
    ): RecyclerView.ViewHolder (binding.root) {

        fun bind(student: Student) {
            with(binding) {
                tvName.text = student.name
                tvEmail.text = student.email
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemStudentBinding.inflate(inflater, parent, false)
        return StudentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = getItem(position)
        holder.bind(student)

    }

}


class DiffCallback : DiffUtil.ItemCallback<Student>() {
    override fun areItemsTheSame(oldItem: Student, newItem: Student) = oldItem.name == newItem.name

    override fun areContentsTheSame(oldItem: Student, newItem: Student) = oldItem == newItem
}