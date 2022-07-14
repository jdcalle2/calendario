package com.example.academico.repository


import com.example.academico.model.Student

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface StudentRepository:JpaRepository<Student, Long> {

    fun findById(id:Long?): Student?




}

















