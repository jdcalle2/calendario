package com.example.academico.repository


import com.example.academico.model.Student

import org.springframework.data.jpa.repository.JpaRepository

interface StudentRepository:JpaRepository<Student, Long> {
    fun findById(id:Long?): Student?

}