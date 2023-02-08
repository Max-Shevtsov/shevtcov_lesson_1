package com.example.shevtcov_lesson_1.data

import com.example.shevtcov_lesson_1.models.Student

object StudentsRepository {

    fun createStudent(): List<Student> {
        return (0..30).toList().map { index ->
            Student(
                age = index,
                name = "student$index",
                email = "student$index@mail.ru",
            )
        }
    }

}