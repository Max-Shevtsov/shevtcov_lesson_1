package com.example.shevtcov_lesson_1.data

import com.example.shevtcov_lesson_1.models.Student

object StudentsRepository {

    fun getStudent(studentType: StudentType): List<Student> {
        val countStudents = when (studentType) {
            is StudentType.MGU -> 50
            is StudentType.KGTU -> 35
            is StudentType.BFU -> 20
        }
        return (0..countStudents).toList().map { index ->
            Student(
                age = index,
                name = "student$index",
                email = "student$index@mail.ru",
            )
        }
    }

    sealed class StudentType {

        object MGU: StudentType()

        object KGTU: StudentType()

        object BFU: StudentType()

    }

}