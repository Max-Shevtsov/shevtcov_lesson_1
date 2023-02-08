package com.example.shevtcov_lesson_1.data

import com.example.shevtcov_lesson_1.models.Student

object StudentsRepository {

    private var students: List<Student> = emptyList()

    fun getStudents(): List<Student> {
        return students.ifEmpty {
            students = createStudent()
            students
        }
    }

    private fun createStudent(): List<Student> {
        return (0..30).toList().map { index ->
            Student(
                age = index,
                name = "student$index",
                email = "student$index@mail.ru",
            )
        }
    }

}