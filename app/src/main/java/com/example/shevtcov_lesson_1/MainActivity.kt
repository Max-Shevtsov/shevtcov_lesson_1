package com.example.shevtcov_lesson_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shevtcov_lesson_1.adapters.StudentsRecyclerAdapter
import com.example.shevtcov_lesson_1.data.StudentsRepository
import com.example.shevtcov_lesson_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val repository = StudentsRepository

    private val adapter: StudentsRecyclerAdapter = StudentsRecyclerAdapter()

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initAdapter()
        renderState()
    }

    private fun initAdapter() {
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.apply {
            rvStudent.layoutManager = layoutManager
            rvStudent.adapter = adapter
        }
    }

    private fun renderState() = binding.apply {
            adapter.submitList(repository.getStudents())
        }

}